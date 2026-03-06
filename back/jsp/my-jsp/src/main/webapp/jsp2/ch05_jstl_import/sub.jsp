<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSTL import (<c:import>)
            --%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>서브 페이지 (JSTL Import)</title>
</head>

<body>
	<% String loginId="admin" ; %>

	<%-- 헤더 포함 --%>
	<c:import url="header.jsp">
		<c:param name="title" value="Sub Page JSTL" />
	</c:import>

	<%-- 섹션 --%>
	<section>
		<h2>서브 페이지 섹션</h2>
		<p>
			로그인 사용자:
			<%= loginId %>
		</p>
	</section>

	<%-- 푸터 포함 --%>
	<c:import url="footer.jsp">
		<c:param name="year" value="2027" />
	</c:import>
</body>

</html>