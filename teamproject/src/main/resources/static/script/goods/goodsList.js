const goodsList = [
  {
    제품코드: "1",
    제품명: "노트북",
    등록자: "id001",
    등록일시: ""
  },
  {
    제품코드: "2",
    제품명: "모니터",
    등록자: "id001",
    등록일시: ""
  },
  {
    제품코드: "3",
    제품명: "PC",
    등록자: "id001",
    등록일시: ""
  }
];

const filter = {
  filterText: ""
};

// 상품 리스트 렌더링
const renderGoodsList = goodsList => {
  goodsList.forEach(list => {
    const listEl = document.createElement("tr");
    listEl.innerHTML =
      `<td>${list.제품코드}</td>` +
      `<td>${list.제품명}</td>` +
      `<td>${list.등록자}</td>` +
      `<td>${list.등록일시}</td>`;
    document.querySelector("tbody#goods-list").append(listEl);
  });
};

// 최초 상품 리스트 렌더링
renderGoodsList(goodsList);
