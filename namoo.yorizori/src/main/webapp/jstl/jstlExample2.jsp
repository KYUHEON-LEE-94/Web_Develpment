<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="score" value="80" scope="request"/>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title></title>
</head>
<body>
  <c:choose>
    <c:when test="${score >= 90}"> 수</c:when>
    <c:when test="${score>=80}">우</c:when>
    <c:when test="${score>=70 }">미</c:when>
    <c:when test="${score>=60 }">양</c:when>
    <c:otherwise>가</c:otherwise>
  </c:choose>
  
</body>
</html>