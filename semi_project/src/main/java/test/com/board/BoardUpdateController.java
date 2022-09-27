package test.com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class BoardInsertController
 */
@WebServlet({ "/boardUpdate.do", "/boardUpdateOK.do" })
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet:" + sPath);

		System.out.println(request.getParameter("board_id"));

		BoardVO vo = new BoardVO();
		vo.setBoard_id(Integer.parseInt(request.getParameter("board_id")));

		BoardDAO dao = new BoardDAOimpl();

		BoardVO vo2 = dao.selectOne(vo);
		System.out.println("vo2:" + vo2);

		request.setAttribute("vo2", vo2);

		request.getRequestDispatcher("boardUpdate.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		System.out.println("doPost:" + sPath);


		System.out.println(request.getParameter("board_id"));
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("contents"));
		System.out.println(request.getParameter("writer"));
		System.out.println(request.getParameter("notice"));

		BoardDAO dao = new BoardDAOimpl();

		BoardVO vo = new BoardVO();
		String board_id = request.getParameter("board_id");
		vo.setBoard_id(Integer.parseInt(board_id));
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		vo.setWriter(request.getParameter("writer"));
		vo.setNotice(request.getParameter("notice"));
		int result = dao.update(vo);
		System.out.println("result:" + result);

		if (result == 1)
			response.sendRedirect("board.do");
		else
			response.sendRedirect("boardUpdate.do?board_id="+board_id);

	}// end doPost

}
