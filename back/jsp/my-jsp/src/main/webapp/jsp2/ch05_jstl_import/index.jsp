<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- 
	JSTL import (<c:import>)
		- JSTL Core 태그 라이브러리 사용
		- 외부 URL 포함 가능 (예:
		<c:import url="http://google.com" />)
		- 요청 파라미터 제어 용이 (<c:param>)
			- 변수 저장 가능 (var 속성)
--%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>메인 페이지 (JSTL Import)</title>
</head>

<body>
	<%
		String loginId = "admin";
	%>

	<%-- 헤더 포함 --%>
	<c:import url="header.jsp">
		<c:param name="title" value="Main JSTL" />
	</c:import>

	<%-- 섹션 --%>
	<section>
		<h2>메인 페이지 섹션</h2>
		<p>
			로그인 사용자:
			<%=loginId%>
		</p>
		<p>JSTL Import는 외부 자원도 포함할 수 있습니다.</p>
	</section>

	<%-- 푸터 포함 --%>
	<c:import url="footer.jsp">
		<c:param name="year" value="2026" />
	</c:import>
</body>

</html>