// Fake goodsData
const goodsData = [
  {
    제품코드: "Tiger Nixon",
    제품명: "System Architect",
    입력자: "$3,120",
    입력일시: "2011/04/25"
  }
];

// Rendering Data Table
$("#goodsList").DataTable({
  paging: false,
  lengthChange: false,
  searching: false,
  ordering: true,
  info: false,
  autoWidth: false,
  data: goodsData,
  columns: [
    { data: "제품코드" },
    { data: "제품명" },
    { data: "입력자" },
    { data: "입력일시" }
  ]
});
