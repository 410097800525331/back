<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
    <title>써브웨이</title>
</head>

<body>
<div id="wrap">
	<div>
		<img src="${pageContext.request.contextPath}/static/assets/img/logo_w.png" alt="써브웨이">
	    <h1>LOGIN</h1>
	    
	    <form method="post" action="${pageContext.request.contextPath}/login">
	        
	        <%-- 아이디 입력 그룹 --%>
	        <div class="login_group">
	            <label for="id">아이디</label> 
	            <input type="text" name="id" id="id" placeholder="아이디" required>
	        </div>
	        
	        <%-- 비밀번호 입력 그룹 --%>
	        <div class="login_group">
	            <label for="pwd">비밀번호</label> 
	            <input type="password" name="pwd" id="pwd" placeholder="비밀번호" required>
	        </div>
	        
	        <%-- 전송 버튼 --%>
	        <div class="login_btn">
	            <button type="submit">로그인</button>
	        </div>
	    </form>
	    
	    <div class="links">
	        <a href="${pageContext.request.contextPath}/member">회원가입</a>
	    </div>
	    
	    <div class="sns_login">
	        <a href="#" onclick="loginWithNaver(); return false;">
				<img src="${pageContext.request.contextPath}/static/assets/img/naver_logo.png" alt="네이버 로그인">
	        </a>
	    </div>
    </div>
</div>

    <script src="${pageContext.request.contextPath}/static/js/login.js"></script>

</body>

</html>