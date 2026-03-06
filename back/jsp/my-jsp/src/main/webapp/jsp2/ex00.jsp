<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%-- <%@ taglib prefix="c" uri="jakarta.tags.core" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	JSP 구성 요소
		1. 디렉티브 (Directive)
			(1) <%@ page %> (필수)
			(2) <%@ include %> (선택)
			(3) <%@ taglib %> (필수) -> JSTL 라이브러리 연결
		2. 스크립트(Script) 요소 
            (1) <%! 선언문 %> -> JSTL
            (2) <% 스크립틀릿 %> -> JSTL
            (3) <%= 표현식 %> -> EL
        3. 액션 태그 -> 일부 JSTL
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 시작하기</title>
</head>
<body>
    <h1>Hello JSP</h1>
    <!-- HTML 주석 -->
    <%-- JSP 주석: 페이지 소스 보기에 출력x --%>
    <%-- <%
        // 스크립틀릿❌ -> JSTL로 전환
        /* Java 로직(제어문, ...) 
           자바의 주석
        */

       int sum = 0;
       for (int i = 1; i<=10; i++) {
            sum += i;
       }
       System.out.println("콘솔 출력: " + sum);

       // out은 JSP 브라우저 출력용 내장객체
       out.println("JSP out 내장객체로 출력: " + sum);
    %> --%>

    <%-- JSTL+EL  --%>
    <c:set var="sum2" value="0" />
    
    <c:forEach var="i" begin="1" end="10">
        <%-- sum2 = sum2 + 1 --%>
        <c:set var="sum2" value="${sum2 + i}" />
    </c:forEach>

    <%--
    	표현식
            - 출력용 Java 코드
            - 변수, 메서드 호출문
    	    <%= 변수 %>
    	    <%= 메서드() %>
    --%>
    <%-- <p>현재 시간: <%= new Date() %></p>
    <p>JSP 표현식으로 출력(이전 방식): <%= sum %></p> --%>
    <p>JSP 표현식으로 출력(EL): ${sum2}</p>
</body>
</html>