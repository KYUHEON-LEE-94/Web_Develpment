<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String html = "<h2 style=\"color:red\">안녕 JSTL</h2>";
request.setAttribute("html", html);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title></title>
</head>
<body>
<!-- el은 Scope객체꺼만 호출가능 -->
    ${html}
    <c:out value="${html}"/>
    <c:out value="${html}" escapeXml="false" />
    
    <!-- request.setAttribute("message", "바보야!"); -->
    <c:set var="message" value="바보야!" scope="request"></c:set>
    메시지: ${message}<br>
    
    <!-- request scope에 저장 -->
    <c:set var="score" value="80" scope="request"></c:set>
    결과: <c:if test="${score >= 60}">패스</c:if><br>
    
    <c:if test="${not empty param.id}">전달받은 아이디: ${param.id}</c:if>
</body>
</html>