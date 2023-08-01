function clickLike(id) {
    let data = {
        id : id,
    }
    const url = "/api/like";
    httpRequest = new XMLHttpRequest();
    httpRequest.open("POST",url, true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader("Content-Type","application/json");
    httpRequest.send(JSON.stringify(data));
    setTimeout(function(){
        window.location.href="/video?id="+id;
    }, 300);
}

function clickDisLike(id) {
    let data = {
        id : id
    }
    const url = "/api/dislike";
    httpRequest = new XMLHttpRequest();
    httpRequest.open("POST",url, true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader("Content-Type","application/json");
    httpRequest.send(JSON.stringify(data));
    setTimeout(function(){
        window.location.href="/video?id="+id;
    }, 300);
}