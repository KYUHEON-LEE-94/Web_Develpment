<%@page import="namoo.bean.Student"%>
<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%-- 왜 UseBean을 사용해야하는가? 사용하지 않을 경우   --%>
<%
//정적 생성
//Student student = new Student();
//동적 생성
//Student student = (Student) pageContext.findAttribute("student");
//if(student == null){
//	student = (Student) Class.forName("namoo.bean.Student").newInstance();
//}
//student.setSsn(10);
//request.setAttribute("student", student);
%>   
<!-- value로 설정   -->
<jsp:useBean id="student" class="namoo.bean.Student" scope="request"></jsp:useBean>
<!-- property는 공개된 속성, Attribute는 숨겨진 속성 -->
<jsp:setProperty name="student" property="ssn" value="10" />
<jsp:setProperty name="student" property="name" value="두루미" />
<jsp:setProperty name="student" property="korean" value="90" />
<jsp:setProperty name="student" property="english" value="100" />
<jsp:setProperty name="student" property="math" value="50" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title></title>
</head>
<body>
학생: <%= request.getAttribute("student") %>
학생 학번: <jsp:getProperty property="ssn" name="student"/>
학생 이름: <jsp:getProperty property="name" name="student"/>
</body>
</html>