package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardBean;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. DAO 객체 생성 (비즈니스 로직 호출 전담)
        BoardDAO bd = new BoardDAO();

        // 2. 전체 게시물 수 조회 (기존 생성한 dao 객체 사용)
        int totalRecord = bd.getTotalCount();
        
        // 3. DAO를 통해 데이터 목록(Model)을 가져옴
        List<BoardBean> list = bd.getBoardList(totalRecord);

        // 4. 결과 데이터를 request 객체에 담음 (View로 전달할 짐 싸기)
        // request.setAttribute(String str, Object obj);
        request.setAttribute("list", list);
        request.setAttribute("totalRecord", totalRecord);

        // 4. View(JSP)로 포워딩
        request.getRequestDispatcher("/view/board/list.jsp").forward(request, response);
    }
}