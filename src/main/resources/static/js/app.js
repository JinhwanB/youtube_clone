const replyDiv = document.querySelector("#replys");
const replyBtn = document.querySelector(".replyPostEdit");

replyBtn.addEventListener("click", () => {
  replyDiv.classList.toggle("hidden");
});

const deleteBtn = document.querySelectorAll(".btn-delete");

deleteBtn.forEach((btn) =>
  btn.addEventListener("click", () => {
    let isDelete = confirm("삭제하시겠습니까?");
  })
);
