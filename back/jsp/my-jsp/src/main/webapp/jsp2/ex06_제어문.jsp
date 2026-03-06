<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 1. JSTL 코어 태그 라이브러리 선언 --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%-- 
	${pageContext.request.contextPath}은 프로젝트명이다.
	-> my_jsp
 --%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제어문: JSTL+EL</title>
<style>
	table,td {border: 1px solid;}
</style>
</head>
<body>
	<%--
		<% %> 안은 자바 코드만
		HTML 출력은 블록 밖에서 실행
	 --%>
    <h1>제어문</h1>
    <h2>조건문: 스크립틀릿</h2>
    <%-- <%
        int score = 75;
        if (score >= 80) {
    %>
            <b>합격입니다.</b>
    <%  } else { %>
            <b>불합격입니다.</b>
    <%  } %> --%>

    <%-- JSTL --%>
    <%-- 2. 변수 설정 --%>
    <c:set var="score" value="75" />
    <%-- JSTL+EL --%>
    <%-- 3. 조건 처리 --%>
    <c:if test="${score >= 80}">
        <b>합격입니다.</b>
    </c:if>
    <c:if test="${score < 80}">
        <b>불합격입니다.</b>
    </c:if>

    <c:choose>
        <c:when test="${score >= 80}">
            <b>당첨되었습니다.</b>
        </c:when>
        <c:otherwise>
            <b>꽝되었습니다.</b>
        </c:otherwise>
    </c:choose>

    <h2>반복문: 스크립틀릿+표현식</h2>
    <%-- <%
        for(int i=1; i<=5; i++) {
            // 콘솔 출력
            System.out.println(i);
    %>
            <b><%= i %></b>
    <%
        }
    %> --%>

    <%-- JSTL+EL --%>
    <%-- 브라우저 캐시 삭제: ctrl+shift+Del --%>
    <%-- 브라우저 캐시 무시 새로고침: ctrl+F5 또는 ctrl+shift+r --%>
    <c:forEach var="i" begin="1" end="5">
        <b style="color:red;">${i}</b>
        <%-- 상대주소 --%>
        <img src="../images/${i}.png" alt="이미지${i}">
        <%-- 절대주소 --%>
        <img src="${pageContext.request.contextPath}/images/${i}.png" alt="이미지${i}">        
        <img src="${path}/images/${i}.png" alt="이미지${i}">        
        <img src="/my-jsp/images/${i}.png" alt="이미지${i}">        
    </c:forEach>
    
    <hr>

    <%-- <%
        int n = 1;
        while (n <= 3) {
    %>
            <p><%= n %>번째 반복</p>
    <%
            n++;
        }
    %> --%>

    <c:forEach var="n" begin="1" end="3" step="1">
        <p>${n}번째 반복</p>
    </c:forEach>

    <h2>구구단(중첩 for)</h2>
    <%-- <table>
        <% 
            for(int i=1; i<=9; i++) { 
        %>
                <tr>
        <%
                for(int j=2; j<=9; j++) { 
        %>
                    <td><%= j %> * <%= i %> = <%= i*j %></td>
        <% 
                } 
        %>
                </tr>
        <%
            }
        %>
 	</table> --%>

    <table>
        <%-- step을 생략하면 1씩 증가 --%>
        <c:forEach var="i" begin="1" end="9">
            <tr>
                <c:forEach var="j" begin="2" end="9">
                    <td>${j} * ${i} = ${i*j}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>

    <h2>향상된 for문</h2>
    <%
            String[] fruits = {"사과", "바나나", "포도"};
    %>
            <ul>
    <%
            for(String fruit : fruits) {
    %>
                    <li><%= fruit %></li>
    <%
            }
    %>
            </ul>

    <%-- JSTL+EL --%>
    <%-- 에러: EL 안에 new 키워드로 객체 생성할 수 없다.
        <c:set var="fruits1" value='${new String[] {"사과", "바나나", "포도"}}' />
    --%>
    <%-- JSTL+표현식 --%>
    <c:set var="fruits2" value='<%= new String[] {"사과", "바나나", "포도", "딸기", "수박", "참외"} %>' />

    <%--
        첫 번째 형식: 
            <c:forEach var="변수명" begin="시작값" end="끝깞" [step="증감값"]> 
        두 번째 형식:
            <c:forEach var="변수명" items="${배열명}" [varStatus="상태변수명"]> 
            속성	의미
            index	0부터
            count	1부터
            first	첫 요소 여부
            last	마지막 요소 여부
    --%>

    <ul>
        <c:forEach var="fruit" items="${fruits1}">
            <li>${fruit}</li>
        </c:forEach>
    </ul>
    <ul>
        <c:forEach var="fruit" items="${fruits2}" varStatus="st">
            <%-- index: 0,1,2... --%>
            <li>${st.index + 1}-${fruit}</li>
            <%-- count: 1,2,3... --%>
            <%-- <li>${st.count}${fruit}</li> --%>
            <%-- first: 첫 번째 요소만 true, 나머지는 false --%>
            <%-- <li>${st.first}${fruit}</li> --%>
            <%-- last: 마지막 요소만 true, 나머지는 false --%>
            <%-- <li>${st.last}${fruit}</li> --%>
        </c:forEach>
    </ul>

</body>
</html>