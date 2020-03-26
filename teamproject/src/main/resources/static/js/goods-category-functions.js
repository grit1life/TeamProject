const insertGoodsCategory = () => {
  const formData = new FormData($("form#goods-category-insert-form")[0]);
  console.log(formData);

  $.ajax({
    type: "post",
    url: "/goodsCategory",
    data: formData,
    processData: false,
    contentType: false,
    success: () => {
      renderMsgModal(
        "확인 메시지",
        `새 분류 '${formData.get("goodsCategoryName")}' 등록되었습니다.`
      );
      renderDynamicGoodsCategory();
    }
  });
};

const renderCategoryForm = () => {
  const formDiv = document.querySelector("#form-div");
  formDiv.innerHTML = `
  <div class="card card-success">
    <div class="card-header">분류관리</div>
  </div>
  <div class="card-body" id="form-list-div"></div>
  `;
  renderCategoryList();
};

const renderCategoryList = () => {
  axios
    .get("/goodsCategory")
    .then(res => {
      console.log(res.data);
      res.data.map(data => {
        const listEl = document.createElement("div");
        listEl.innerHTML = `
          <div class="row list-row ">
            <div class="col-sm-3 my-auto">
              ${data.goodsCategoryCode}
            </div>

            <div class="col-sm-3 my-auto">
              ${data.goodsCategoryName}
            </div>
    
            <div class="col-sm-3 my-auto">
              <button
                class="btn btn-default category-update-btn"
                name="${data.goodsCategoryCode}"
              >
                수정
              </button>
              <button
                class="btn btn-default category-update-btn"
                name="${data.goodsCategoryCode}"
              >
                삭제
              </button>
            </div>
          </div>
        `;
        document.querySelector("#form-list-div").appendChild(listEl);
      });
    })
    .catch(err => {
      console.error(err);
    });
};

const renderDynamicGoodsCategory = () => {
  const dynamicGoodsCategorySelect = $("select#dynamic-goods-category-select");
  dynamicGoodsCategorySelect.html(`<option value="">분류선택</option>`);

  axios
    .get("/goodsCategory")
    .then(res => {
      res.data.map(data => {
        const categoryEl = $(
          `
          <option value="${data.goodsCategoryCode}">${data.goodsCategoryCode} : ${data.goodsCategoryName}</option>
          `
        );
        dynamicGoodsCategorySelect.append(categoryEl);
      });
    })
    .catch(err => {
      console.error(err);
    });
};
