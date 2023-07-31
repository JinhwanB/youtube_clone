const replyDiv = document.querySelector("#replys");
const replyBtn = document.querySelector(".replyPostEdit");

replyBtn.addEventListener("click", () => {
  replyDiv.classList.toggle("hidden");
});

function onDelete(id){
    let isDelete = confirm("삭제하시겠습니까?");
    if(isDelete){
        location.href = "video/comment/delete?id=" + id;
    }
}
