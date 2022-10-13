<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean id="user" class="namoo.user.dto.User" scope="page"/>
<jsp:setProperty property="id" name="user" value="bobo"/>
<jsp:setProperty property="name" name="user" value="boboname"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title></title>
</head>
<body>
아이디:	<%= user.getId() %><br>
이름:  	<%= user.getName() %><br>
<h2>----------------EL사용------------------------</h2>
아이디: ${user.id}<br>
이름: ${user.name}<br>

<h3>EL에서 리터럴(값) 출력</h3>
${'야이 바보야'}, ${"야이 바보야"}<br>
${10},${156.7},${3213123}<br>
<!-- null을 빈문자열로 형변환해서 출력함 -->
${true},${false}, ${null}<br>

<h3>EL에서 연산자</h3>
${10+50}<br>
${"50"+10 }<br> <!-- 문자열과 숫자 연산 시 숫자로 자동 형변환된다. -->
${true&&false}<br>
${!(100 >= 90)}<br>

<%
String name = null;
String message = "";
List<String> list = new ArrayList<String>();
%>
<!-- empty = empty냐? -->
${empty name},${empty message }, ${empty user.id}. ${empty list } 
</body>
</html>