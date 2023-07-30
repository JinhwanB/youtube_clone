function replyDelete(id) {
    let data = {
        id : id,
    }
    httpRequest = new XMLHttpRequest();
    httpRequest.open("DELETE","/board/delete", true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader("Content-Type","application/json");
    httpRequest.send(JSON.stringify(data));
    setTimeout(function(){
        window.location.href="/reply/delete/"+id;
    }, 300);
}

function replyUpdate(id, content) {
    let data = {
        id : id,
        content : content,
    }
    httpRequest = new XMLHttpRequest();
    httpRequest.open("POST","/reply/update", true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader("Content-Type","application/json");
    httpRequest.send(JSON.stringify(data));
    setTimeout(function(){
        window.location.href="/player";
    }, 300);
}