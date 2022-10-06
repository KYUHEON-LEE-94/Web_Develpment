<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title>JSP 수업Start</title>
<link rel="stylesheet" href="css/005.css">
</head>
<body>	
	<h2>오늘부터 JSP 수업입니다.</h2>
	<%
	Calendar cal = Calendar.getInstance();
	String today = String.format("%1$tF %1$tT", cal);
	out.println(today);
	%>
	<h1>동적 구구단 출력</h1>
	<table>
	<%
	for(int i =2; i<10; i++){
		out.println("<tr>");
		for(int j =1; j<10; j++){
			out.println("<td>"+i+"X"+j+"="+(i*j)+"</td>");
		}
		out.println("</tr>");
	}
	%>
	</table>
	<% 
	String message = "JSP 쉽지않아..";
	out.println("바보!"); 
	out.println(message);
	%>
	<%= "바보" %><br>
	<%= message %>
	
	<%! 
	private int count=0;
	%>
	<%! 
	public int getNextCount(){
		return ++count;
	}
	%>
	<h2>
	당신은 <%= getNextCount()%> 번째 방문자입니다.
	</h2>
	
	<!-- 이 주석은 HTML주석으로 화면에 출력은 안되지만 이 안의 자바 코드는 서버에서 돌아가고 있음 -->
	<%-- JSP 주석을 사용하면 코드가 서버에서도 동작을 하지않음 --%>
	
</body>
</html>