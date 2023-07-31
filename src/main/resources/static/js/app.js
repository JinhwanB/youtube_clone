const replyDiv = document.querySelector("#replys");
const replyBtn = document.querySelector(".replyPostEdit");

replyBtn.addEventListener("click", () => { // 대댓글 창 숨기고 보이기
  replyDiv.classList.toggle("hidden");
});

function onDelete(id){ // 댓글 삭제 경고창
    let isDelete = confirm("삭제하시겠습니까?");
    if(isDelete){
        location.href = "video/comment/delete?id=" + id;
    }
}

// 댓글 수정
const commentReadOnlyInput = document.querySelector(".commentModifyForm input");
const commentReadOnlyTextArea = document.querySelector(".commentModifyForm textarea");
const modifyBtns = document.querySelectorAll(".btn-modify");

modifyBtns.forEach(modifyBtn => modifyBtn.addEventListener("click", () => {
    const inputTag = modifyBtn.parentNode.parentNode.previousElementSibling.previousElementSibling;
    const textareaTag = modifyBtn.parentNode.parentNode.previousElementSibling;

    if(modifyBtn.innerText === "수정"){
        modifyBtn.innerText = "완료";
        inputTag.removeAttribute("readonly");
        textareaTag.removeAttribute("readonly");
        inputTag.focus();
    }else{
        modifyBtn.innerText = "수정";
        inputTag.setAttribute("readonly", "readonly");
        textareaTag.setAttribute("readonly", "readonly");
        inputTag.parentNode.submit();
    }
}));
