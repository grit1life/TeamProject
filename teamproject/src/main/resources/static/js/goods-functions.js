// // 정적 변수 선언
const listFormTitleDiv = document.querySelector("#list-form-title-div");
const listFormDiv = document.querySelector("#list-form-div");
const listDiv = document.querySelector("#list-div");
const formDiv = document.querySelector("#form-div");

// // 기능 함수

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

  alert("파일사이즈 : " + fileSize + ", 최대파일사이즈 : " + maxSize);

  if (fileSize > maxSize) {
    alert("첨부파일 사이즈는 2MB 이내로 등록 가능합니다.");
    $("input#file-input").val("");
    removePreview();
    return;
  } else {
    renderPreview(e);
  }
};

const insertGoods = async () => {
  const formData = new FormData($("form#insert-form")[0]);

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
        renderViewForm(data.goodsCode);
      }, 500);
      setTimeout(() => {
        activeList(data.goodsCode);
      }, 1000);
    }
  });
};

const deleteGoods = e => {
  const goodsCode = e.target.name;

  axios
    .delete(`/goods/${goodsCode}`)
    .then(res => {
      console.log(res.data.msg);
      renderList();
      renderIntroForm();
    })
    .catch(err => {
      console.error(err);
    });
};

// // 렌더링 함수

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

// 리스트 폼 타이틀 렌더링

const renderGoodsListFormTitle = () => {
  listFormTitleDiv.innerHTML = "";
  const listtFormTitleEl = document.createElement("div");
  listtFormTitleEl.innerHTML = `
  <div class="card card-success">
    <div class="card-header">
      상품리스트
    </div>
  </div>
  `;
  listFormTitleDiv.appendChild(listtFormTitleEl);
};

// 리스트 폼 렌더링

const renderGoodsListForm = () => {
  listFormDiv.innerHTML = "";
  listFormEl = document.createElement("div");
  listFormEl.innerHTML = `
  <div class="row" style="margin-bottom: 10px;">
    <div class="col-md-8">
      <div class="form-group my-auto">
        <select class="form-control" id="dynamic-goods-category-select"></select>
      </div>
    </div>
    <div class="col-md-4">
      <div class="form-group my-auto">
        <select class="form-control">
          <option>최신등록순</option>
          <option>오래된등록순</option>
        </select>
      </div>
    </div>
  </div>  
  `;
  listFormDiv.appendChild(listFormEl);
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
            <div class="col-md-4 my-auto">
              <img
                src="../images/${data.convertFileName}"
                alt="../pages/img-not-found.png"
                class="rounded mw-100"
              />
            </div>
            <div class="col-md-7 my-auto">
              <p>
                ${data.goodsName}
              </p>
              <p style="color: #696969;">
                ${data.goodsCategoryName}
              </p>
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
        안녕하세요 {사용자이름} 님.
      </p>
      <p>
        UI 작업 미완료.
      </p>
      <p>
        상품 리스트 조회 구현중(미완성)
      </p>
      <p>
        상품 입력 기능 구현중(미완성)
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
        <div class="form-group">
          <div class="col-6" style="margin: 0 auto;">
            <img
              id="preview-img"
              src="../images/img-not-found.png"
              style= "margin: 0 auto"
              height = "150"
              width = "200"
            />
            <input
              type="file"
              name="file"
              class="form-control-file border-0"
              id="file-input"
            />
          </div>
        </div>

        <div class="form-group">
          <label>상품분류</label>
          <select name="goodsCategoryCode" class="form-control" id="dynamic-goods-category-select"></select>
        </div>

        <div class="form-group">
          <label>상품명</label>
          <input type="text" name="goodsName" class="form-control" placeholder="상품명을 입력하세요. 입력값은 자동으로 중복검사를 진행합니다." required />
        </div>

        <div class="form-group">
          <label>바코드</label>
          <input
            type="text"
            name="goodsBarcode"
            class="form-control"
            maxlength="6"
            placeholder="12자리 영문+숫자,입력하지 않을 시 중복값이 아닌 값으로 자동으로 생성됩니다."
          />
        </div>

        <div class="form-group">
          <label>기타메모</label>
          <input
            type="text"
            name="goodsDesc"
            class="form-control"
          />
        </div>

        <div class="card-footer">
          <button type="submit" id="insert-btn" class="btn btn-primary">
            등록
          </button>
          <button type="button" id="cancle-btn" class="btn btn-default pull-right">
            취소
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
    const formEl = document.createElement("div");
    formEl.innerHTML = `
      <div class="card card-success">
        <div class="card-header">상품조회</div>
      </div>
      <div class="card-body">
        <div class="row">
          <div class="col-6" style="margin: 0 auto;">
            <img
              src="../images/${res.data.convertFileName}"
              class="rounded mw-100"
              alt="ImageNotFound"
            />
          </div>
        </div>

        <div class="form-group">
          <label>상품코드</label>
          <input
            name="goodsCode"
            value="${res.data.goodsCode}"
            class="form-control"
            readonly
          />
        </div>

        <div class="form-group">
          <label>상품분류</label>
          <input
            name="goodsCategoryCode"
            value="${res.data.goodsCategoryCode} : ${res.data.goodsCategoryName}"
            class="form-control"
            readonly
          />
        </div>

        <div class="form-group">
          <label>상품명</label>
          <input
            name="goodsName"
            value="${res.data.goodsName}"
            class="form-control"
            readonly
          />
        </div>

        <div class="form-group">
          <label>바코드</label>
          <input
            name="goodsBarcode"
            value="${res.data.goodsBarcode}"
            class="form-control"
            readonly
          />
        </div>

        <div class="form-group">
          <label>등록직원</label>
          <input
            name="goodsInputStaffCode"
            value="${res.data.goodsInputStaffCode}"
            class="form-control"
            readonly
          />
        </div>

        <div class="form-group">
          <label>등록일</label>
          <input
            name="goodsInputDate"
            value="${res.data.goodsInputDate}"
            class="form-control"
            readonly
          />
        </div>

        <div class="form-group">
          <label>상세설명</label>
          <input
            name="goodsDesc"
            value="${res.data.goodsDesc}"
            class="form-control"
            readonly
          />
        </div>

        <button
          type="button"
          name="${res.data.goodsCode}"
          id="update-form-btn"
          class="btn btn-warning"
        >
          정보수정
        </button>
        <button
          type="button"
          name="${res.data.goodsCode}"
          id="delete-btn"
          class="btn btn-danger"
        >
          삭제
        </button>
        <button type="button" id="cancle-btn" class="btn btn-default">
          취소
        </button>
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
      <div class="card card-warning">
        <div class="card-header">정보수정</div>
      </div>
      <form id="view-form">
        <div class="card-body">
          <div class="col-6" style="margin: 0 auto;">
              <img
                src="../images/${res.data.convertFileName}"
                class="rounded mw-100"
                alt="ImageNotFound"
              />
          </div>

          <div class="form-group">
            <label>상품분류</label>
            <select name="goodsCategoryCode" class="form-control" id="dynamic-category-select"></select>
          </div>

          <div class="form-group">
            <label>상품명</label>
            <input
              name="goodsName"
              value="${res.data.goodsName}"
              class="form-control"
            />
          </div>

          <div class="form-group">
            <label>바코드</label>
            <input
              name="goodsBarcode"
              value="${res.data.goodsBarcode}"
              class="form-control"
            />
          </div>

          <div class="form-group">
            <label>상세설명</label>
            <input
              name="goodsDesc"
              value="${res.data.goodsDesc}"
              class="form-control"
            />
          </div>

          <button
            type="button"
            name="${res.data.goodsCode}"
            id="update-btn"
            class="btn btn-warning"
          >
            수정
          </button>
          <button type="button" id="cancle-btn" class="btn btn-default">
            취소
          </button>
        </div>
      </form>
      `;
    formDiv.appendChild(formEl);
    renderDynamicCategory();
  });
};
