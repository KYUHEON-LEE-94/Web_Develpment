<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="namoo.user.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="namoo.common.factory.ServiceFactory"%>
<%@page import="namoo.common.factory.ServiceFactoryImpl"%>
<%@page import="namoo.user.service.UserService"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% 
ServiceFactory serviceFactory = ServiceFactoryImpl.getInstance();
UserService userService = serviceFactory.getUserService();
List<User> list = userService.listAll();
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
		<h1>Looney's Portfolio Website</h1>
		<p>Resize the browser window to see the effect.</p>
	</div>

	<%--탑 네비게이션 시작 --%>
	<jsp:include page="/IncludeFolder/navigation.jsp" />
	<%--탑 네비게이션 끝 --%>
	<!-- header end -->

	<!-- main body start -->
	<div class="row">
		<div class="leftcolumn">
			<div class="w3-container">
				<div class="w3-center">
					<h3>회원 목록(총 ?명)</h3>
				</div>

				<!-- 검색폼 -->
				<div class="search">
					<form>
						<select name="searchType">
							<option value="all">전체</option>
							<option value="id">아이디</option>
							<option value="name">이름</option>
						</select> <input type="text" name="searchValue" placeholder="Search..">
						<input type="submit" value="검색">
					</form>
				</div>

				<div class="w3-responsive w3-card-4">
					<table class="w3-table w3-striped w3-bordered">
						<thead>
							<tr class="w3-theme">
								<th>번호</th>
								<th>아이디</th>
								<th>이름</th>
								<th>이메일</th>
								<th>가입일자</th>
							</tr>
						</thead>
						<tbody>
						<%
						for(int i=0; i<list.size(); i++){
							User user = list.get(i);
						%>
							<tr class="w3-white">
								<td><%= ++i %></td>
								<td><a href="view.jsp?id=<%= user.getId() %>"><%= user.getId() %></a></td>
								<td><%= user.getName() %></td>
								<td><%= user.getEmail() %></td>
								<td><%= user.getRegdate() %></td>								
							</tr>
						<%
						}
						%>

							
						</tbody>
					</table>
				</div>
				<div class="pagination">
					<a href="#">&laquo;</a> <a href="#">1</a> <a class="active"
						href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a>
					<a href="#">6</a> <a href="#">7</a> <a href="#">8</a> <a href="#">9</a>
					<a href="#">10</a> <a href="#">&raquo;</a>
				</div>
			</div>
		</div>

		<!-- aside start -->
		<%-- 우측 메뉴 시작 --%>
		<jsp:include page="/IncludeFolder/aside.jsp" />
		<%-- 우측메뉴 끝 --%>
		<!-- aside end -->
	</div>
	<!-- main body end -->

	<!-- footer start -->

	<%-- 바닥글 시작--%>
	<jsp:include page="/IncludeFolder/footer.jsp" />
	<%-- 바닥글 끝--%>
	<!-- footer end -->
</body>
</html>