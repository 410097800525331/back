<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL+JSTL</title>
</head>
<body>
	<%-- 
		[선언문]
		<%! 
			int totalCount = 100; 
			public int plus(int a, int b) {
				return a + b;
			}
		%> 
	--%>

	<%-- JSTL --%>
	<c:set var="totalCount2" value="100" />
	<c:set var="a2" value="10" />
	<c:set var="b2" value="20" />

	<%-- 
		[스크립틀릿]
		<% 
        	Date now2 = new Date(); 

			int sum = 0;
			for (int i=1; i<=10; i++) {
				sum += i;
			}
    	%>
	--%>

	<%-- 변수 선언 및 할당 --%>
	<c:set var="sum" value="0" />
	<%-- 변수 선언과 동시에 객체 생성 --%>
	<c:set var="now2" value="<%= new java.util.Date() %>" />

	<%--
		[표현식] 
		변수 출력: <%= totalCount %>
		메서드 호출: <%= plus(10, 20) %>
		선언문으로 작성한 변수: <%= now1 %><br>
		선언문으로 작성한 변수: <%= new Date() %>
		스크립틀릿으로 작성한 변수: <%= now2 %>
	--%>

	<%-- EL --%>
	변수 출력: ${totalCount2}
	<br>
	<div>변수 출력: ${a2 + b2}</div>
	날짜 출력: ${now2}
</body>
</html>