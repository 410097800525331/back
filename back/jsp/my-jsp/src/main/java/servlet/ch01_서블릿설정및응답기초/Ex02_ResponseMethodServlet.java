package servlet.ch01_서블릿설정및응답기초;

// 임포트: ctrl+shift+o 또는 ctrl+spacebar
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mime")
public class Ex02_ResponseMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 문자열: text/plain
		// 한글이 깨지지 않도록 컨텐츠 타입 설정
		response.setContentType("text/plain; charset=UTF-8");
		response.getWriter().println("English");
		response.getWriter().println("한글");
		
		/* 
			갱신이 안되어 이전 내용으로 출력된다면?
			1. 톰캣 서버 종료
				- project > clean: 소스 코드 재빌드
				- servers > clean: 배포 환경 동기화
			2. 웹 브라우저 갱신
				- ctrl+shift+del -> 캐시 삭제
		*/

		// HTML: text/html
		// HTML 태그를 인식하게 컨텐츠 타입 설정
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h1>한글</h1>");
		PrintWriter out = response.getWriter();
		out.println(""
				+ "<table style='border:1px solid;'>"
				+ "	<tr>"
				+ "		<td style='border:1px solid;'>Cell 1</td>"
				+ "		<td style='border:1px solid;'>Cell 2</td>"
				+ "	</tr>"
				+ "</table>");

		// 자바스크립트
		out.println("<script>alert('Hello JavaScript!');</script>");

		// JSON(JavaScript Object Notation)
		// 예: {"name": "hong"}
		// 이스케이프 문자: \"
		response.setContentType("application/json; charset=UTF-8");
		out.println("{\"name\": \"hong\"}");

	} // doGet() 끝

}
