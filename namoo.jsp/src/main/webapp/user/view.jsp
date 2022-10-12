<%@page import="namoo.user.dto.User"%>
<%@page import="namoo.common.factory.ServiceFactoryImpl"%>
<%@page import="namoo.user.service.UserService"%>
<%@page import="namoo.common.factory.ServiceFactory"%>
<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String id = request.getParameter("id");
ServiceFactory serviceFactory = ServiceFactoryImpl.getInstance();
UserService userService = serviceFactory.getUserService();
User user = userService.findById(id);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="/css/basic.css">
<link rel="stylesheet" type="text/css" href="/css/pagination.css">
<style>
@media ( min-width : 1200px) {
	.container {
		max-width: 970px;
	}
}
</style>
</head>
<body>
	<!-- header start -->
	<div class="header">
		<h1>Lee's Portfolio Website</h1>
		<p>Resize the browser window to see the effect.</p>
	</div>

	<%-- 탑 네비게이션 시작 --%>
	<jsp:include page="/IncludeFolder/navigation.jsp" />
	<%-- 탑 네비게이션 끝 --%>
	<!-- header end -->

	<!-- main body start -->
	<div class="row">
		<div class="leftcolumn">
			<div class="w3-content">
				<div class="w3-container" id="contact">
					<h2>회원상세</h2>
					<form action="regist.jsp" method="post">
						<p>
							<input class="w3-input w3-padding-16 w3-border" type="text"
								value=<%= user.getId() %> readonly>
						</p>
						<p>
							<input class="w3-input w3-padding-16 w3-border" type="text"
								value=<%= user.getName() %> readonly>
						</p>
						<p>
							<input class="w3-input w3-padding-16 w3-border" type="text"
								value=<%= user.getEmail() %> readonly>
						</p>
						<p>								
						<input class="w3-input w3-padding-16 w3-border" type="text" readonly
						
								<% if(user.getRegdate() == null){
								%>
									value='미공개' 				
								<% 
								}else{
								%>	
									value=<%= user.getRegdate() %> 
									<% 
								} %>
								
						>		
						</p>
						<p>
							<button class="w3-button w3-red w3-padding-large" type="button" onclick="location.href='/'">
								홈으로
								</button>
								<button class="w3-button w3-blue w3-padding-large" type="reset" onclick="location.href='/user/list.jsp'">
								사용자 목록
								</button>
						</p>
					</form>
				</div>
			</div>
		</div>

		<%-- 우측 메뉴 시작 --%>
		<jsp:include page="/IncludeFolder/aside.jsp" />
		<%-- 우측 메뉴 끝 --%>

	</div>
	<!-- main body end -->

	<!-- footer start -->
	<jsp:include page="/IncludeFolder/footer.jsp" />
	<!-- footer end -->

</body>
</html>