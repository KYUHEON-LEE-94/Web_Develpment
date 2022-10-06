<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
<% String customer = "이규헌";
String item = "TV";
session.setAttribute("customer", customer);
session.setAttribute("item", item);
response.sendRedirect("/sessionExample2.jsp");
%>
</body>
</html>