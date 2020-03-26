// // 정적 변수 선언
const listDiv = document.querySelector("#list-div");
const formDiv = document.querySelector("#form-div");

// 파일 업로드 함수
const imageUpload = e => {
  const maxSize = 2 * 1024 * 1024; // 2MB
  let fileSize = 0;

  const browser = navigator.appName;

  if (browser == "Microsoft Internet Explorer") {
    const oas = new ActiveXObject("Scripting.FileSystemObject");
    fileSize = oas.getFile(file.value).size();
  } else {
    fileSize = e.target.files[0].size;
  }

  if (fileSize > maxSize) {
    renderMsgModal("업로드 불가", "파일 첨부는 2MB까지 가능합니다.");
    $("#file-input").val("");
    removePreview();
    return;
  } else {
    renderPreview(e);
  }
};

const insertGoods = async () => {
  const formData = new FormData($("#insert-form")[0]);
  console.log(formData);

  await $.ajax({
    type: "post",
    url: "/goods",
    processData: false,
    contentType: false,
    data: formData,
    error: err => {
      renderMsgModal(
        "오류 메시지",
        "서버 에러가 발생했습니다. 관리자에게 문의 바랍니다."
      );
      console.log(err);
    },
    success: data => {
      renderMsgModal("확인 메시지", "요청이 정상적으로 처리되었습니다.");
      setTimeout(() => {
        renderGoodsList();
      }, 500);
      setTimeout(() => {
        renderViewForm(data);
      }, 500);
      setTimeout(() => {
        activeList(data);
      }, 1000);
    }
  });
};

const deleteGoods = e => {
  const goodsCode = e.target.name;
  console.log(goodsCode);

  axios
    .delete(`/goods/${goodsCode}`)
    .then(res => {
      console.log(res.data.msg);
      renderGoodsList();
      renderIntroForm();
    })
    .catch(err => {
      console.error(err);
    });
};

const updateGoods = async () => {
  const formData = new FormData($("#update-form")[0]);
  console.log(formData);

  await $.ajax({
    type: "put",
    url: "/goods",
    processData: false,
    contentType: false,
    data: formData,
    error: err => {
      renderMsgModal(
        "오류 메시지",
        "서버 에러가 발생했습니다. 관리자에게 문의 바랍니다."
      );
      console.log(err);
    },
    success: data => {
      renderMsgModal("확인 메시지", "요청이 정상적으로 처리되었습니다.");
      setTimeout(() => {
        renderGoodsList();
      }, 500);
      setTimeout(() => {
        renderViewForm(data);
      }, 500);
      setTimeout(() => {
        activeList(data);
      }, 1000);
    }
  });
};

// 프리뷰 이미지 생성
const renderPreview = e => {
  if (e.target.files && e.target.files[0]) {
    const reader = new FileReader();
    reader.onload = e => {
      document
        .querySelector("#preview-img")
        .setAttribute("src", e.target.result);
    };
    reader.readAsDataURL(e.target.files[0]);
  }
};

// 프리뷰 이미지 제거
const removePreview = () => {
  document
    .querySelector("#preview-img")
    .setAttribute("src", "../images/img-not-found.png");
};

// 상품 리스트 렌더링
const renderGoodsList = () => {
  listDiv.innerHTML = "";

  axios
    .get("/goods")
    .then(res => {
      res.data.map(data => {
        const listEl = document.createElement("div");
        listEl.innerHTML = `
          <div class="row list-row" style="border-bottom: 1px solid #CBCBCB;">
            <div class="col-md-3 my-auto">
              <img
                src="../images/${data.convertImgName}"
                alt="이미지가 없습니다."
                width="100"
                height="75"
              />
            </div>
            <div class="col-md-5 my-auto">
              <p>
                ${data.goodsName}
              </p>
              <p style="color: #696969;">
                ${data.goodsCategoryName}
              </p>
            </div>
            <div class="col-md-3 my-auto">
              ${data.stockCount}
            </div>
            <div class="col-md-1 my-auto">
              <button
                class="btn btn-default btn-lg pull-right view-form-btn"
                name="${data.goodsCode}"
              >
                >
              </button>
            </div>
          </div>
        `;
        listDiv.appendChild(listEl);
      });
    })
    .catch(err => {
      console.error(err);
    });
};

const activeList = goodsCode => {
  $("div.list-actived").removeClass("list-actived");
  $(`button[name='${goodsCode}']`)
    .closest(".list-row")
    .addClass("list-actived");
};

const removeActive = () => {
  $("div.list-actived").removeClass("list-actived");
};

// 대시보드 폼 렌더링
const renderIntroForm = () => {
  formDiv.innerHTML = "";

  const formEl = document.createElement("div");
  formEl.innerHTML = `
    <div class="card card-success">
      <div class="card-header">대시보드</div>
    </div>
    <div class="card-body" style="min-height: 600px;">
      <p>
        UI 작업 미완료
      </p>
      <p>
        상품 리스트 조회 미완성
      </p>
      <p>
        상품 입력 기능 미완성
      </p>
    </div>
  `;
  formDiv.appendChild(formEl);
  removeActive();
};

// 입력 폼 렌더링
const renderInsertForm = () => {
  formDiv.innerHTML = "";
  const formEl = document.createElement("div");
  formEl.innerHTML = `
    <div class="card card-success">
      <div class="card-header">새로운상품</div>
    </div>
    <form id="insert-form" role="form" enctype="multipart/form-data">
      <div class="card-body">
        <div class="row">
          <div class="col-md-2">
            <div class="form-group">
              <label>
              <img
                id="preview-img"
                src="../images/img-not-found.png"
                style="margin: 0 auto"
                width="100"
                height="75"
              />
              <input
                type="file"
                name="img"
                class="custom-file-input"
                accept="image/*"
                id="file-input"
              />
              </label>
            </div>
          </div>

          <div class="col-md-10">
            <div class="form-group row">
              <label class="col-sm-2">상품분류</label>
              <div class="col-sm-8">
                <select
                  name="goodsCategoryCode"
                  class="form-control"
                  id="dynamic-goods-category-select"
                ></select>
              </div>
              <div class="col-sm-2">
                <button type="button" class="btn btn-default" id="goods-category-add-btn">
                  <i class="fa fa-plus-square"> 추가</i>
                </button>
              </div>
            </div>

            <div class="form-group row">
              <label class="col-sm-2">상품명</label>
              <div class="col-sm-8">
                <input
                  type="text"
                  name="goodsName"
                  class="form-control"
                  placeholder="상품명을 입력하세요."
                  required
                />
              </div>
            </div>

            <div class="form-group row">
              <label class="col-sm-2">바코드</label>
              <div class="col-md-8">
                <input
                  type="text"
                  name="goodsBarcode"
                  class="form-control"
                  maxlength="12"
                  placeholder="12자리 숫자+영문"
                />
              </div>
            </div>

            <div class="form-group row">
              <label class="col-sm-2">기타메모</label>
              <div class="col-md-8">
                <input type="text" name="goodsDesc" class="form-control" />
              </div>
            </div>
          </div>
        </div>

        <div class="card-footer">
          <button type="submit" id="insert-btn" class="btn btn-outline-primary">
            <i class="fa fa-plus-square-o"> 등록</i>
          </button>
        </div>
      </div>
    </form>
    `;
  formDiv.appendChild(formEl);
  renderDynamicGoodsCategory();
  removeActive();
};

// 조회 폼 렌더링
const renderViewForm = async goodsCode => {
  formDiv.innerHTML = "";

  await axios.get(`/goods/${goodsCode}`).then(res => {
    console.log(res.data);
    const formEl = document.createElement("div");
    formEl.innerHTML = `
        <div class="card card-success">
          <div class="card-header">상품조회</div>
        </div>
        <div class="card-body">
          <div class="row">
            <div class="col-md-2">
              <img
                src="../images/${res.data.convertImgName}"
                alt="../images/img-not-found.png"
                width="100"
                height="75"
              />
            </div>

            <div class="col-md-10">
              <div class="form-group row">
                <label class="col-sm-2">상품코드</label>
                <div class="col-sm-8">
                  <input
                    name="goodsCode"
                    value="${res.data.goodsCode}"
                    class="form-control-plaintext"
                    readonly
                  />
                </div>
              </div>

              <div class="form-group row">
                <label class="col-sm-2">상품분류</label>
                <div class="col-sm-8">
                  <input
                    name="goodsCategoryCode"
                    value="${res.data.goodsCategoryCode} : ${res.data.goodsCategoryName}"
                    class="form-control-plaintext"
                    readonly
                  />
                </div>
              </div>

              <div class="form-group row">
                <label class="col-sm-2">상품명</label>
                <div class="col-sm-8">
                  <input
                    name="goodsName"
                    value="${res.data.goodsName}"
                    class="form-control-plaintext"
                    readonly
                  />
                </div>
              </div>

              <div class="form-group row">
                <label class="col-sm-2">바코드</label>
                <div class="col-sm-8">
                  <input
                    name="goodsBarcode"
                    value="${res.data.goodsBarcode}"
                    class="form-control-plaintext"
                    readonly
                  />
                </div>
              </div>

              <div class="form-group row">
                <label class="col-sm-2">등록일</label>
                <div class="col-sm-8">
                  <input
                    name="goodsInputDate"
                    value="${res.data.goodsInputDate}"
                    class="form-control-plaintext"
                    readonly
                  />
                </div>
              </div>

              <div class="form-group row">
                <label class="col-sm-2">상세설명</label>
                <div class="col-sm-8">
                  <input
                    name="goodsDesc"
                    value="${res.data.goodsDesc}"
                    class="form-control-plaintext"
                    readonly
                  />
                </div>
              </div>
            </div>
          </div>

          <div class="card-footer">
            <button type="submit" id="update-form-btn" name="${res.data.goodsCode}" class="btn btn-outline-primary">
              수정
            </button>
          </div>
        </div>
      `;
    formDiv.appendChild(formEl);
    activeList(goodsCode);
  });
};

// 수정 폼 렌더링
const renderUpdateForm = async goodsCode => {
  formDiv.innerHTML = "";

  await axios.get(`/goods/${goodsCode}`).then(res => {
    const formEl = document.createElement("div");
    formEl.innerHTML = `
      <div class="card card-success">
        <div class="card-header">수정</div>
      </div>
      <form id="update-form" role="form" enctype="multipart/form-data">
        <div class="card-body">
          <div class="row">
            <div class="col-md-2">
              <div class="form-group">
                <label>
                  <img
                    src="../images/${res.data.convertImgName}"
                    alt="../images/img-not-found.png"
                    id="preview-img"
                    width="100"
                    height="75"
                  />
                  <input
                    type="file"
                    name="img"
                    class="custom-file-input"
                    id="file-input"
                  />
                </label>
              </div>
            </div>

            <div class="col-md-10">
              <div class="form-group row">
                <label class="col-sm-2">상품코드</label>
                <div class="col-sm-8">
                  <input
                    name="goodsCode"
                    value="${res.data.goodsCode}"
                    class="form-control-plaintext"
                    readonly
                  />
                </div>
              </div>

              <div class="form-group row">
                <label class="col-sm-2">상품분류</label>
                <div class="col-sm-8">
                  <select
                    name="goodsCategoryCode"
                    class="form-control"
                    id="dynamic-goods-category-select"
                    value="${res.data.goodsCategoryCode}"
                  ></select>
                </div>
                <div class="col-sm-2">
                  <button type="button" class="btn btn-default">
                    <i class="fa fa-plus-square"> 추가</i>
                  </button>
                </div>
              </div>

              <div class="form-group row">
                <label class="col-sm-2">상품명</label>
                <div class="col-sm-8">
                  <input
                    type="text"
                    name="goodsName"
                    class="form-control"
                    value="${res.data.goodsName}"
                    placeholder="상품명을 입력하세요."
                    required
                  />
                </div>
              </div>

              <div class="form-group row">
                <label class="col-sm-2">바코드</label>
                <div class="col-md-8">
                  <input
                    type="text"
                    name="goodsBarcode"
                    class="form-control"
                    maxlength="12"
                    value="${res.data.goodsBarcode}"
                  />
                </div>
              </div>

              <div class="form-group row">
                <label class="col-sm-2">기타메모</label>
                <div class="col-md-8">
                  <input type="text" name="goodsDesc" class="form-control" value="${res.data.goodsDesc}" />
                </div>
              </div>
            </div>
          </div>

          <div class="card-footer">
            <button type="submit" id="update-btn" class="btn btn-outline-primary">
              저장
            </button>
            <button
              type="button"
              id="delete-btn"
              name="${res.data.goodsCode}"
              class="btn btn-outline-dark pull-right"
            >
              삭제
            </button>
          </div>
        </div>
      </form>
      `;
    formDiv.appendChild(formEl);
    renderDynamicGoodsCategory();
  });
};
