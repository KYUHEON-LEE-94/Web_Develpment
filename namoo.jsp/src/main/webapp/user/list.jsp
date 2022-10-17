<%@page import="namoo.common.web.Page"%>
<%@page import="namoo.common.web.Params"%>
<%@page import="namoo.user.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="namoo.user.service.UserService"%>
<%@page import="namoo.common.factory.ServiceFactoryImpl"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String type = request.getParameter("type");
if (type == null) {
	type = "";
}
String value = request.getParameter("value");
if (value == null) {
	value = "";
}
UserService userService = ServiceFactoryImpl.getInstance().getUserService();
//List<User> list = userService.search(type, value);
//int count = userService.searchCount(type, value);

// 페이징 처리를 위해 필요한 정보
// 전체검색개수, 한페이당 보여지는 목록 개수, 한 페이지당 보여지는 페이지 개수

//한페이지당 10개씩 보여주겠다.
int pageSize = 3;

//페이지 번호 5개씩~
int pageCount = 5;

//요청 페이지 - default값으로 1번째 페이지 보여주겠다.
int requestPage = 1;

String size = request.getParameter("size");
//size != null라는 건, 사용자가 요청한 사이즈가 있다는 것. 그래서 pageSize값을 변경
if (size != null) {
	pageSize = Integer.parseInt(size);
}

//몇번 페이지를 보여줄것이냐
String selectPage = request.getParameter("page");
if (selectPage != null) {
	requestPage = Integer.parseInt(selectPage);
}

Params params = new Params(type, value, pageSize, pageCount, requestPage);
List<User> list = userService.search(params);

//전체 개수를 확인하기 위해서
int count = userService.searchCount(type, value);
Page paging = new Page(params, count);
paging.build();
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
					<h3>
						회원 목록(총
						<%=count%>명)
					</h3>
				</div>

				<!-- 검색폼 -->
				<div class="search">
					<form>
						<select name="type">
							<option value="">전체</option>
							<option value="id">아이디</option>
							<option value="name">이름</option>
						</select> <input type="text" name="value" placeholder="Search.."> <input
							type="submit" value="검색">
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
							if (count != 0) {
								int i = 1;
								for (User user : list) {
							%>
							<tr class="w3-white">
								<td><%=i++%></td>
								<td><a href="/user/view.jsp?id=<%=user.getId()%>"><%=user.getId()%></a></td>
								<td><%=user.getName()%></td>
								<td><%=user.getEmail()%></td>
								<td><%=user.getRegdate()%></td>
							</tr>
							<%
							}
							} else {
							%>
							<tr>
								<td colspan="5" style="color: red; text-align: center">회원이
									존재하지 않습니다.</td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				<div class="pagination">
					<%
					if (paging.isShowFirst()) {
					%>
					<a href="<%= paging.getQueryString(1) %>">처음으로</a>

					<%
					}
					%>

					<%
					if (paging.isShowPrevious()) {
					%>
						<a href="<%= paging.getQueryString(paging.getPreviousStartPage()) %>">&laquo; </a>

					<%
					}
					%>
					<%
					for (int i = paging.getStartPage(); i <= paging.getEndPage(); i++) {
						if (i == params.getRequestPage()) {
					%>
						<a class='active'><%=i%></a>
					<%
					} else {
					%>
						<a href="<%= paging.getQueryString(i) %>"><%= i%></a>
					<%
					}
					}
					%>
					<%
					if (paging.isShowNext()) {
					%>
						<a href="<%= paging.getQueryString(paging.getNextStartPage()) %>">&raquo;</a>

					<%
					}
					%>

					<%
					if (paging.isShowLast()) {
					%>
						<a href="<%= paging.getQueryString(paging.getPageCount()) %>">끝으로</a>

					<%
					}
					%>
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