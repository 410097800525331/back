package jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet("/ch08/resquest")
public class Ch08ResquestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String protocol = request.getProtocol();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		String method = request.getMethod();
		StringBuffer requestURL = request.getRequestURL();
		String requestURI = request.getRequestURI();
		String useBrowser = request.getHeader("User-Agent");
		String fileType = request.getHeader("Accept");
		
		// 브라우저에 문자열로 표시
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h1>Request Example2(서블릿)</h1>");
		
		response.getWriter().println("<p>프로토콜 : " + protocol + "</p>");
		response.getWriter().println("<p>서버의 이름 : " + serverName + "</p>");
		response.getWriter().println("<p>서버의 포트 번호 : " + serverPort + "</p>");
		response.getWriter().println("<p>사용자 컴퓨터의 주소 : " + remoteAddr + "</p>");
		response.getWriter().println("<p>사용자 컴퓨터의 이름 : " + remoteHost + "</p>");
		response.getWriter().println("<p>사용 method : " + method + "</p>");
		response.getWriter().println("<p>요청 경로(URL) : " + requestURL + "</p>");
		response.getWriter().println("<p>요청 경로(URI) : " + requestURI + "</p>");
		response.getWriter().println("<p>현재 사용하는 브라우저 : " + useBrowser + "</p>");
		response.getWriter().println("<p>브라우저가 지원하는 file의 type : " + fileType + "</p>");
	}

}
