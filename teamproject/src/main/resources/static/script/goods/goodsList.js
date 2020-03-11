// 가짜 데이터
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

// 파일 업로드 플러그인
$(document).ready(function() {
  bsCustomFileInput.init();
});

// 검색용 필터
const filter = {
  searchText: ""
};

// 검색창 입력값 바인딩
// document.querySelector("input#search-text").addEventListener("input", e => {
//   filter.searchText = e.target.value;
// });

// 리스트 렌더링
const renderList = goodsList => {
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

// 최초 리스트 렌더링
renderList(goodsList);
