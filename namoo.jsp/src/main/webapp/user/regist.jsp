<%@page import="java.net.URLEncoder"%>
<%@page import="namoo.user.service.UserService"%>
<%@page import="namoo.common.factory.ServiceFactoryImpl"%>
<%@page import="namoo.user.service.UserServiceImpl"%>
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
<jsp:useBean id="user" class="namoo.user.dto.User"/>
<!-- 파라미터 이름과 클래스의 속성 이름이 같아야지만 적용이됨 -->
<jsp:setProperty name="user" property="*"/>

<%-- <jsp:setProperty name="user" property="name" param="name"/>
<jsp:setProperty name="user" property="passwd" param="passwd"/>
<jsp:setProperty name="user" property="email" param="email"/> --%>


<%
UserService userService = ServiceFactoryImpl.getInstance().getUserService();
userService.registUser(user);
//회원 가입 결과 화면으로 이동
//forward(이중등록 문제 가능성)

//PRG 적용
 //인코딩하는 방법
String name = URLEncoder.encode(user.getName(),"utf-8");
response.sendRedirect("/user/registResult.jsp?id="+user.getId()+"&name="+name+"&email="+user.getEmail()+"");
%>
<%-- <jsp:forward page="/user/registRes<%-- <jsp:forward page="/user/registResult.jsp"></jsp:forward> --%>ult.jsp"> --%>

