<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <%-- 
            <%
                String siteName = "JSP Study";
                int year = java.time.Year.now().getValue();

                <p>Copyright <%= year %> <%= siteName %></p>
            %> 
        --%>
        <footer>
            <p>Copyright <%= request.getParameter("year") %> <%= request.getParameter("siteName") %></p> 
        </footer>
    </body>
</html>