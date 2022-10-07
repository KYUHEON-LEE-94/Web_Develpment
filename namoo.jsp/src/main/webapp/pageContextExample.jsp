<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
pageContext.setAttribute("id", "bang");
pageContext.setAttribute("name", "LEE", pageContext.REQUEST_SCOPE);
pageContext.setAttribute("age", 10, pageContext.SESSION_SCOPE);
//application.getRequestDispatcher("/pageContextExample2.jsp").forward(request, response);

//redirect에서는 새로운 request 객체가 만들어졌기 때문에 검색안됨
response.sendRedirect("/pageContextExample2.jsp");
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
아이디:	<%= pageContext.getAttribute("id") %> <br>
이름 예시1:	<%= pageContext.getAttribute("name") %><br>
이름 예시2:	<%= pageContext.getAttribute("name", pageContext.REQUEST_SCOPE) %><br>
나이:	<%= pageContext.findAttribute("age") %><br>
</body>
</html>