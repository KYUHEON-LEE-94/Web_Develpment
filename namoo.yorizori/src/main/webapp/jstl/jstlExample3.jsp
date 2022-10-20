<%@page import="namoo.yorizori.user.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
//Servlet(컨트롤러) 코드라 가정
List<String> teams = new ArrayList<String>();
teams.add("맨유");
teams.add("맨시티");
teams.add("리버풀");
teams.add("토트넘");
teams.add("첼시");

request.setAttribute("teams", teams);

List<User> users = new ArrayList<User>();
users.add(new User("fe", "DOg", "1111", "fesg@", "20221020"));
users.add(new User("jgyf", "Cat", "1111", "dbf@", "2022920"));
users.add(new User("reyhb", "Hamster", "1111", "fgerv@", "2022820"));

request.setAttribute("users", users);
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title></title>
</head>
<body>
  <!-- i값을 1부터 10까지 1개씩 증가시키면서 반복 -->
  <!-- var의 값은 pagecontext에 저장되는 키값 -->
  <table>
    <c:forEach var="i" begin="2" end="9" step="1">
      <tr>
        <c:forEach var="j" begin="1" end="9" step="1">
          <td>${i}*${j}=${i*j}
        </c:forEach>
      </tr>
    </c:forEach>
  </table>

  <h2>--forEach예시--</h2>

  팀목록<br> 
  <select>
    <c:forEach var="name" items="${teams}">
      <option>${name}
    </c:forEach>
  </select>
  <br><br>
  
회원목록<br>  
<table border="1">
  <c:forEach var="user" items="${users}">
  <tr>
  <td>${user.id }</td> <td>${user.name }</td><td> ${user.email}</td><td>${user.regdate}</td>
  </tr>
  </c:forEach>
</table>

<c:url var="someUrl" value="https://www.naver.com">
<!--위의 밸류에 파라미터로 무언가를 넘기고 싶을때 -->
<c:param name="id" value="bangry"/>
<c:param name="passwd" value="1111"/>
</c:url>
<a href="${someUrl}">연결</a>

<c:redirect url="jstlExample4.jsp">
<!-- utf-8 인코딩도해줌 -->
<c:param name="name" value="한글"/>
</c:redirect>
</body>
</html>