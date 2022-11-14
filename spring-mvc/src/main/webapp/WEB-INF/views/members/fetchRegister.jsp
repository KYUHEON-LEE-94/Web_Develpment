<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<script type="module" defer>

document.querySelector('#button').addEventListener("click",regist);

function regist() {

    let member ={
        id: "bang",
        password: "1111",
        name: "뱅",
        age: 20
    }

    let option = {
        method:"POST",
        headers:{
            "Content-type": "application/json",
        },
        body: JSON.stringify(member),
    };

fetch("/request-json2",option)
.then(res => res.json())
.then(member => receiveJson(member))
.catch(err => console.log("err: ", err))

}

function receiveJson(member){
    let message = "아이디"+member.id+", 이름: "+member.name
    console.log(message);
    document.querySelector("#result").textContent = message;
}




</script>
<body>
    <h2>회원 가입 화면</h2>
    <button id='button'>버튼 꾸욱</button>
    <h2>결과 화면</h2>
    <p id='result'></p>
</body>
</html>