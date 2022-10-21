<%-- 웹컨테이너에 의해 발생하는 모든 에러내용을 보여주기 위한 JSP --%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isErrorPage="true" %>

<% response.setStatus(HttpServletResponse.SC_OK); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Server Error :: KOREAITACADEMY</title>
<style type="text/css"> 
* {margin:0;padding:0;}
#error_content {margin:0; padding:0;}
#error_content *{margin:0; padding:0; color:#444; list-style:none; font-size:14px; line-height:normal; font-family:돋움, Dotum, 굴림, Gulim, AppleGothic, Sans-serif;}
#error_content img{border:none;}
#error_content a{text-decoration:underline; color:#444;}
#error_content a:visited{text-decoration:none; color:#666;}
#error_content a:hover{text-decoration:underline;}
#error_content {width:350px; _width /**/:510px; height:206px; _height:208px; margin:0 auto; margin-top:50px; padding:0 0 0 214px; border:1px solid #e5e5e5; background:#FFF url(http://static.naver.com/common/error/bg_error_s.gif) no-repeat 32px 48px; text-align:left;}
#error_content h2 {margin:48px 0 14px 0; padding:0; color: blue;}
#error_content h2 a{text-decoration:none; color: blue;}
#error_content p {margin:0; padding:0; color:#888; font:12px/1.5em 돋움,Dotum,AppleGothic,sans-serif;}
#error_content p.btn {padding:15px 0 0 1px; font-size:0;}
#error_content p.btn img {margin-right:1px; *margin-right:1px;}
</style>
</head>
<body>
<div id="error_content">
	<h2>시스템 장애가 발생하였습니다.<br>관리자(<a href="mailto:admin@bangry.co.kr">bangry.co.kr</a>)에게 문의바랍니다.</h2>
	<div class="content">
		<p style="color: red">[디버깅] : <%=exception.toString() %></p>
	</div>
	<br/>
	<p>
		<input type="submit" value="이전 페이지" style="padding: 3px; color: #333333; border: 1px solid #ddd; margin: 5px 5px" onclick="history.back();"/>
		<input type="button" value="홈 페이지" style="padding: 3px; color: #333333; border: 1px solid #ddd;" onclick="location.href='/index.jsp'"/>
	</p>
</div>
</body>
</html>







