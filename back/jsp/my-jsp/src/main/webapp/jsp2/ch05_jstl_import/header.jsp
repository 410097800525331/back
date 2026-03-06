<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<h1>
		<a href="index.jsp">로고 (JSTL)</a>
	</h1>
	<h2>현재 페이지: ${param.title}</h2>
	<nav>
		<ul>
			<li><a href="sub.jsp">서브 페이지1</a></li>
			<li><a href="#">서브 페이지2</a></li>
			<li><a href="#">서브 페이지3</a></li>
		</ul>
	</nav>
</header>