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
@WebServlet({ "/write.do", "/writeOK.do" })
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardWriteController() {
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

		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		System.out.println("user_id:"+user_id);
		if(user_id != null) {
			request.getRequestDispatcher("board.jsp").forward(request, response);
		}else {
			response.sendRedirect("write.do");
		}
		

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

		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("content"));
		System.out.println(request.getParameter("writer"));
		System.out.println(request.getParameter("notice"));

		BoardDAO dao = new BoardDAOimpl();

		BoardVO vo = new BoardVO();
		vo.setMeeting_id(request.getIntHeader("meeting_id"));
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		vo.setWriter(request.getParameter("writer"));
		vo.setnotice(request.getParameter("notice"));
		int result = dao.createBoard(vo);
		System.out.println("result:" + result);

		if(result==1)
			response.sendRedirect("board.do");
		else 
			response.sendRedirect("write.do");

	}// end doPost

}
