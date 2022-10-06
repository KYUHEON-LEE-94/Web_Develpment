<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title>장바구니 리스트</title>
</head>
<body>

고객명: <%= session.getAttribute("customer") %> <br>
상품명:  <%= session.getAttribute("item") %><br>
</body>
</html>