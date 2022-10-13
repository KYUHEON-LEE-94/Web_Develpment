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
<%
request.setAttribute("id", "bangbang");
request.setAttribute("name", "벵벵");

%>
<h2>EL에서 제공하는 내장객체 11개</h2>
<%= request.getAttribute("id") %><br>
<%= request.getAttribute("passwd") %><br>
${requestScope.id}<br>
[]로 접근: ${requestScope['name']}<br>
${requestScope.passwd}<br>
<!-- findAttribute를 사용하는 느낌 -->
Scope생략 가능: ${id}, ${name}<br>
</body>
</html>