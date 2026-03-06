<%-- page 디렉티브 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%--
	JSP 구성 요소
		1. 디렉티브 (Directive)
			(1) <%@ page %> (필수)
			(2) <%@ include %> (선택)
			(3) <%@ taglib %> (필수) -> JSTL 라이브러리 연결
            
		2. 스크립트(Script) 요소 
            (1) <%! 선언문: 변수·메서드 선언 %>
            (2) <% 스크립틀릿: Java 로직(제어문, ...) %>
            (3) <%= 표현식: 출력 %>

        3. 액션 태그(Action Tag)

--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 시작하기</title>
</head>
<body>
	<h1>Hello JSP</h1>
	<%! // 선언문(Declaration)
        // 변수 선언 -> 클래스의 멤버 변수로 변환
        int totalCount = 100;

        // 메서드 정의
        public int plus(int a, int b) {
            return a + b;
	    }
    %>

	<!-- HTML 주석 -->
	<%-- JSP 주석: 페이지 소스 보기에 출력x --%>
	<%
        // 스크립틀릿(Scriptlet)
        // Java 로직(제어문, ...) 
		// 메서드 정의❌❌
        // 변수 선언 -> _jspService() 메서드 안의 지역 변수로 변환
        int sum = 0;

        // 제어문
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("콘솔 출력: " + sum);

        // out은 JSP 브라우저 출력용 내장객체
        out.println("JSP out 내장객체로 출력: " + sum);
	%>

	<%--
    	표현식(Expression)
            - 출력용 Java 코드
            - 변수, 메서드 호출
    	    <%= 변수 %>
    	    <%= 메서드() %>
    --%>
	<p>
		현재 시간:
		<%=new Date()%></p>
	<p>
		JSP 표현식으로 출력(이전 방식):
		<%=sum%></p>
</body>
</html>