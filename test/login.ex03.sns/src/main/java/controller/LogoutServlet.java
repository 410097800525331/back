package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * [LogoutServlet]
 * 사용자의 세션을 종료하여 로그아웃 상태로 만드는 컨트롤러입니다.
 * @WebServlet("/logout") : 브라우저에서 /logout 경로로 요청을 보내면 이 서블릿이 실행됩니다.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * [GET 방식 처리]
     * 로그아웃은 보통 링크 클릭(<a href="/logout">)을 통해 발생하므로 doGet에서 처리합니다.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        /*
         * 1. 세션 가져오기: request.getSession(false)
         * - true(기본값): 세션이 없으면 새로 생성합니다. (로그아웃할 때는 불필요)
         * - false: 이미 존재하는 세션이 있으면 반환하고, 없으면 null을 반환합니다.
         * - 로그아웃은 기존 세션을 지우는 것이 목적이므로 false를 사용하는 것이 메모리 효율상 좋습니다.
         */
        HttpSession session = request.getSession(false);
        
        /*
         * 2. 세션 무효화: session.invalidate()
         * - 세션 객체가 null이 아니라는 것은 현재 로그인 상태(또는 세션 유지 상태)임을 의미합니다.
         * - invalidate()를 호출하면 해당 세션에 저장된 모든 데이터(idKey, userName 등)가 
         * 서버 메모리에서 완전히 삭제됩니다.
         */
        if (session != null) {
            session.invalidate();
        }
        
        /*
         * 3. 페이지 리다이렉트: response.sendRedirect()
         * - 세션을 성공적으로 삭제한 후, 사용자에게 다시 메인 페이지(/main)를 요청하도록 지시합니다.
         * - 주소창이 /main으로 바뀌며, index.jsp의 JSTL 조건문에 의해 
         * 다시 '로그인/회원가입' 버튼이 보이게 됩니다.
         */
        response.sendRedirect(request.getContextPath() + "/main");
    }
}