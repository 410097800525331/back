package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

/**
 * [LoginServlet]
 * 사용자의 로그인 요청 처리 및 로그인 페이지 이동을 담당하는 컨트롤러입니다.
 * @WebServlet("/login") : 브라우저에서 /login 경로로 들어오는 요청을 이 서블릿과 매핑합니다.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * [GET 방식 처리]
	 * 사용자가 로그인 페이지에 처음 접속할 때(주소창 입력, 링크 클릭 등) 호출됩니다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		/*
		 * [Forward 이동]
		 * - 서버 내부에서 주소 이동 없이 화면만 /view/login/login.jsp의 내용을 보여줍니다.
		 * - 브라우저 주소창은 여전히 /login으로 표시됩니다.
		 */
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	}

	/**
	 * [POST 방식 처리]
	 * 로그인 폼(login.jsp)에서 사용자가 아이디/비밀번호를 입력하고 '로그인' 버튼을 눌렀을 때 호출됩니다.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// 1. 인코딩 설정: 클라이언트로부터 전달받은 한글 데이터가 깨지지 않도록 UTF-8로 설정합니다.
		request.setCharacterEncoding("UTF-8");
		
		// 2. 응답 형식 설정: 서버가 클라이언트(브라우저)에게 보낼 컨텐츠가 HTML이며 UTF-8임을 지정합니다.
		response.setContentType("text/html; charset=UTF-8");

		// 3. 폼 데이터 수집: <input name="id">와 <input name="pwd">에 입력된 값을 가져옵니다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// 4. 비즈니스 로직 수행: DAO(Data Access Object)를 통해 DB에 해당 정보가 있는지 확인합니다.
		MemberDAO mDAO = new MemberDAO();
		boolean result = mDAO.loginMember(id, pwd); // DB 조회 결과 (성공 true / 실패 false)

		// 5. 응답 처리 객체 생성: 자바스크립트 등을 브라우저에 직접 출력하기 위한 통로입니다.
		PrintWriter out = response.getWriter();
		
		if (result) {
			/* [로그인 성공 시] */
			
			// (중요) 세션 생성: 로그인 상태를 유지하기 위해 서버 메모리에 사용자 정보를 저장합니다.
			// 현재 코드에서는 리다이렉트만 수행하므로, 아래와 같은 세션 설정 코드가 추가되는 것이 일반적입니다.
			HttpSession session = request.getSession();
			session.setAttribute("idKey", id);      // 세션에 아이디 저장
			session.setAttribute("userName", id);    // 세션에 이름(또는 닉네임) 저장
			
			/*
			 * [Redirect 이동]
			 * - 브라우저에게 "새로운 주소(/main)로 다시 접속해!"라고 명령합니다.
			 * - 주소창이 /main으로 변경되며, 새로고침 시 중복 로그인 요청이 발생하는 것을 방지합니다.
			 */
			response.sendRedirect(request.getContextPath() + "/main");
			
		} else {
			/* [로그인 실패 시] */
			
			// 자바스크립트를 사용하여 사용자에게 알림창(alert)을 띄우고 이전 페이지로 돌려보냅니다.
			out.println("<script>");
			out.println("  alert('아이디 또는 비밀번호가 일치하지 않습니다.');");
			out.println("  history.back();"); // 브라우저의 '뒤로가기'와 동일한 동작
			out.println("</script>");
		}
		
		// 자원 해제: 출력을 위해 사용한 스트림을 닫아줍니다.
		out.close();
	}
}