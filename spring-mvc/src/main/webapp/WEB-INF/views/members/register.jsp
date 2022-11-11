<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title></title>
</head>
<body>
  <h1>회원가입 화면</h1>
    <form action="/members/register" method="post">
      <input type="text" name="id" placeholder="아이디">
      <input type="password" name="passwd" placeholder="비밀번호">
      <input type="text" name="name" placeholder="이름">
      <input type="number" name="age" placeholder="나이">
      <input type="submit" value="회원등록">
    </form>
</body>
</html>