const initRender = () => {
  renderGoodsListFormTitle();
  renderGoodsListForm();
  renderGoodsList();
  renderIntroForm();
  renderDynamicGoodsCategory();

  const d = new Date();
  const currentDate = `
        ${d.getFullYear()}년 ${d.getMonth() + 1}월 ${d.getDate()}일`;
  const currentTime = `
        ${d.getHours()}시 ${d.getMinutes()}분 ${d.getSeconds()}초`;
  renderMsgModal(
    "시작 메시지",
    `안녕하세요. 오늘은 ${currentDate}, 현재 ${currentTime} 입니다.`
  );
};
