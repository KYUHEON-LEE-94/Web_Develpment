<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String loginId =null;
Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie cookie:cookies){
		String name = cookie.getName();
		if(name.equalsIgnoreCase("loginId")){
			loginId = cookie.getValue();
		}
	}
}

%>
<div class="rightcolumn">
	<div class="card">
		<div>
			<%if(loginId == null){
				%>				
			<form action="/user/login.jsp" method='post'>
				<input type="text" id="id" name="id" placeholder="Identifier...">
			    <input type="password" id="passwd" name="passwd" placeholder="Password...">
			    <input type="submit" value="Login">
			</form>				
				<%
			}else{
				%>
				<p><%= loginId %>님 로그인중</p>	
				<input type='submit' value='LogOut' onclick="location.href ='/user/logout.jsp'">		
				<%
			} %>
		</div>
	</div>

	<div class="card">
		<h3>Popular Post</h3>
		<div class="fakeimg">
			<p>Image</p>
		</div>
		<div class="fakeimg">
			<p>Image</p>
		</div>
		<div class="fakeimg">
			<p>Image</p>
		</div>
	</div>
	<div class="card">
		<h3>Follow Me</h3>
		<p>Some text..</p>
	</div>
</div>