package test.com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet({ "/boardDelete.do", "/boardDeleteOK.do" })
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardDeleteController() {
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

		if(sPath.equals("/boardDelete.do")) {
			request.getRequestDispatcher("boardDelete.jsp").forward(request, response);
		}else if(sPath.equals("/boardDeleteOK.do")) {
			String board_id = request.getParameter("board_id");
			System.out.println(board_id);
			
			BoardDAO dao = new BoardDAOimpl();

			BoardVO vo = new BoardVO();
			vo.setBoard_id(Integer.parseInt(board_id));
			
			int result = dao.delete(vo);
			if (result == 1)
				response.sendRedirect("board.do");
			else
				response.sendRedirect("boardDelete.do?board_id="+board_id);
			
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}// end doPost

}
