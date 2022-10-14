<%@page import="namoo.user.dto.User"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="namoo.user.service.UserService"%>
<%@page import="namoo.common.factory.ServiceFactoryImpl"%>
<%@page import="namoo.user.service.UserServiceImpl"%>
<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

UserService userService = ServiceFactoryImpl.getInstance().getUserService();
User user = userService.login(id,passwd);

//회원일 경우
if(user != null){
	Cookie loginCookie = new Cookie("loginId", user.getId());
	//유효패스를 설정하지 않으면 현재 페이지 이외에서는 사용할 수 없음
	loginCookie.setPath("/");
	response.addCookie(loginCookie);
	response.sendRedirect("/");
}else{
	%>
	<script type="text/javascript">
	alert("아이디 다시 한번 확인");
	history.back();
	</script>
	<%
}

%>



