<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 표현식 --%>
	<%= "직접 출력하는 메시지" %>
	<%= "Hello JSP" %>
	<%= "<br>" %>
	<%= (10 + 20) %>

	<hr>

	<%-- EL --%>
	${"직접 출력하는 메시지"}
	${"Hello JSP"}
	${"<br>"}
	${(10 + 20)}
</body>
</html>