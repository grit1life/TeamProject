const renderDynamicGoodsCategory = () => {
  const dynamicGoodsCategorySelect = $("select#dynamic-goods-category-select");
  dynamicGoodsCategorySelect.html("<option>분류선택</option>");

  axios
    .get("/goodsCategory")
    .then(res => {
      res.data.map(item => {
        const categoryEl = $(
          `
          <option value="${item.goodsCategoryCode}">${item.goodsCategoryCode} : ${item.goodsCategoryName}</option>
          `
        );
        dynamicGoodsCategorySelect.append(categoryEl);
      });
    })
    .catch(err => {
      console.error(err);
    });
};
