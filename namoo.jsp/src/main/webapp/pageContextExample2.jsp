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

이름 예시2:	<%= request.getAttribute("name") %><br>
이름 예시1:	<%= pageContext.getAttribute("name") %><br>
나이:	<%= pageContext.findAttribute("age") %><br>
<%= page %> <br> 
<%= this %>
</body>
</html>