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
@WebServlet({ "/view.do" })
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardViewController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet:"+sPath);
		
		System.out.println(request.getParameter("board_id"));
		
		BoardVO vo = new BoardVO();
		vo.setBoard_id(Integer.parseInt(request.getParameter("board_id")));
		
		BoardDAO dao = new BoardDAOimpl();
		
		BoardVO vo2 = dao.selectOne(vo);
		System.out.println("vo2:"+vo2);
		
		
		request.setAttribute("vo2", vo2);
		
		request.getRequestDispatcher("view.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}//end doPost

}
