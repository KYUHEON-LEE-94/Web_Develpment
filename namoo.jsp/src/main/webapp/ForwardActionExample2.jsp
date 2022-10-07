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
이름:	 <%= request.getParameter("name") %> <br>
나이: 	<%= request.getParameter("age") %> <br>

//해당 서블렛을 실행된 결과만 가져옴
<jsp:include page="/hello.jsp"></jsp:include>
</body>
</html>