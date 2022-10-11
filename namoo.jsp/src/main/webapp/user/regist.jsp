<%@page import="namoo.bean.User"%>
<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <% 
request.setCharacterEncoding("utf-8"); 
String id = request.getParameter("id");
String name = request.getParameter("name");
String passwd = request.getParameter("passwd");
String email = request.getParameter("email");
User user = new User();
user.setId(id);
user.setName(name);
user.setPasswd(passwd);
user.setEmail(email);
//조금 있다 DB처리..
%>     --%>

<!-- param으로 받아와서 설정   -->
<jsp:useBean id="user" class="namoo.bean.User"/>
<!-- 파라미터 이름과 클래스의 속성 이름이 같아야지만 적용이됨 -->
<jsp:setProperty name="user" property="*"/>

<%-- <jsp:setProperty name="user" property="name" param="name"/>
<jsp:setProperty name="user" property="passwd" param="passwd"/>
<jsp:setProperty name="user" property="email" param="email"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title></title>
</head>
<body>
	사용자: <%=user %>
</body>
</html>