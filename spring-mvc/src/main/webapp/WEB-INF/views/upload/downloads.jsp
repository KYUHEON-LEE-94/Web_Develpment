<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
  <h2>다운로드 파일 목록</h2>
  <ul>
    <c:forEach items="${list}" var="file">
      <li><a href="/download/${file.name}">${file.name}</a></li>
    </c:forEach>
  </ul>
  <h2>이미지 파일 목록</h2>
  <ul>
    <c:forEach items="${list}" var="file">
      <li><a href="/images/${file.name}">${file.name}</a></li>
    </c:forEach>
  </ul>
</body>
</html>