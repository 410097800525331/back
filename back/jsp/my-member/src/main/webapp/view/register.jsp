<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>Subway 회원 가입</h1>
	<form action="${getContext.request.contextPath}/register" method="post">
		<div>
			<label for="userid">아이디: </label>
			<input type="text" name="userid" id="userid" required>
		</div>
		<div>
			<%-- name의 값은 testdb의 users 테이블의 컬럼명과 같아야 한다. --%>
			<label for="userpw">비밀번호: </label>
			<input type="password" name="userpw" id="userpw" required>
		</div>
		<button type="submit">가입하기</button>
	</form>
</body>
</html>