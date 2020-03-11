// Fake goodsData
const goodsData = [
  {
    key: "1",
    value: "one"
  },
  {
    key: "2",
    value: "two"
  },
  {
    key: "3",
    value: "three"
  }
];

// Rendering Data Table
$("tbody#goodsList").DataTable({
  data: goodsdata
});
