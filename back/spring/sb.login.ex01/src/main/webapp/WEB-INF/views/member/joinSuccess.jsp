<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>가입 완료</title></head>
<body>
	<%@ include file="../common/header.jsp" %>
    <h3>${sessionScope.userName}님, 가입을 축하드립니다.</h3>
    <br>
    <a href="/login">로그인 페이지로 이동하기</a>
    <a href="/main">메인 페이지로 이동하기</a>
</body>
</html>