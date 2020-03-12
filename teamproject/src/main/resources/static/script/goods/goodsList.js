// 파일 업로드 플러그인
$(document).ready(function() {
  bsCustomFileInput.init();
});

// 리스트 렌더링
const renderList = goodsList => {
  // 리스트를 렌더링 하기 전에 이전에 존재하던 리스트를 공백으로 만듦
  document.querySelector("tbody#goods-list").innerHTML = "";
  // 리스트 렌더링
  goodsList.forEach(list => {
    const listEl = document.createElement("tr");
    listEl.innerHTML =
      `<td>${list.goodsCode}</td>` +
      `<td>${list.goodsName}</td>` +
      `<td>${list.goodsInputStaffCode}</td>` +
      `<td>${list.goodsInputDate}</td>` +
      `<td><input type="button" class="btn btn-warning" value="편집" goodsCode="${list.goodsCode}" onclick="editFun()"/></td>`;
    document.querySelector("tbody#goods-list").appendChild(listEl);
  });
};

// 데이터 가져오기
const getList = () => {
  $.ajax({
    type: "POST",
    url: "/goodsList",
    success: data => {
      renderList(data);
    }
  });
};

// 최초 리스트 렌더링
getList();

// 입력 버튼 이벤트
document.querySelector("button#input-btn").addEventListener("click", e => {
  e.preventDefault();
  input();
});

// 입력 처리
const input = () => {
  const inputValue = $("form#input-form").serialize();
  $.ajax({
    type: "POST",
    url: "/goodsInput",
    data: inputValue,
    success: () => {
      getList();
    }
  });
};

// 입력 취소 버튼 이벤트

// 조회 버튼 함수
const editFun = () => {
  console.log(this.goodscode);
  update();
};

// 조회 화면 처리
const update = () => {
  console.log("update it");
};

// 편집 버튼 이벤트

// 편집 화면 처리

// 수정 버튼 이벤트

// 이전 버튼  이벤트

// 수정 처리 이벤트

// 삭제 버튼 이벤트

// 삭제 처리
