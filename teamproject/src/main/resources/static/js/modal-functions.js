const modalDiv = document.querySelector("#modal-div");

const modalCheck = {
  modalOn: false
};

const renderMsgModal = (title, msg) => {
  modalDiv.innerHTML = "";

  if (modalCheck.modalOn) {
    return;
  } else {
    modalCheck.modalOn = true;
  }

  const modalEl = document.createElement("div");
  modalEl.innerHTML = `
  <div class="modal fade" id="msg-modal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">${title}</h4>
          <button type="button" class="close" onclick="removeModal();" data-dismiss="modal">
            &times;
          </button>
        </div>

        <div class="modal-body">
          ${msg}
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-primary" onclick="removeModal();" data-dismiss="modal">
            확인
          </button>
        </div>
      </div>
    </div>
  </div>
  `;
  modalDiv.appendChild(modalEl);

  $("#msg-modal").modal({ backdrop: "true" });
};

const removeModal = () => {
  modalCheck.modalOn = false;
};
