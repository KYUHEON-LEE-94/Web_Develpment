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
	요청방식: <%= request.getMethod() %> <br>
	요청 URI: <%= request.getRequestURI() %><br>
	요청 파라미터: <%= request.getParameter("id")%><br>
	<% 
	Cookie[] cookies = request.getCookies(); 
	if(cookies != null){
	for(Cookie cookie:cookies){
		String cookieName = cookie.getName();
		String cookieValue = cookie.getValue();
		%><%= cookieName%> : <%= cookieValue%><br>
		<%
	}
	}
	%>
</body>
</html>