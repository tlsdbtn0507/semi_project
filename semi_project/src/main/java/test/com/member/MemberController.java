package test.com.member;

import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
=======
>>>>>>> 0574ae638d7fa4a00e889ffeb0db092dac3d4166
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD

/**
 * Servlet implementation class MemberController
 */
@WebServlet({ "/m_insert.do", "/insertOK.do", "/m_update.do", "/m_updateOK.do", "/m_delete.do", "/m_deleteOK.do",
		"/m_selectAll.do", "/m_selectOne.do", "/m_searchList.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
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

		System.out.print("doGet():");
		System.out.println(sPath);
		if (sPath.equals("/m_insert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
			rd.forward(request, response);
		}
//		else if (sPath.equals("/m_selectAll.do")) {
//			new SelectAllAction().execute(request, response);
//		} else if (sPath.equals("/m_update.do")) {
//			new UpdateAction().execute(request, response);
//		} else if (sPath.equals("/m_delete.do")) {
//			RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
//			rd.forward(request, response);
//		} else if (sPath.equals("/m_selectOne.do")) {
//			new SelectOneAction().execute(request, response);
//		} else if (sPath.equals("/m_searchList.do")) {
//			new SearchListAction().execute(request, response);
//		} else if (sPath.equals("/m_insertOK.do")) {
//			response.sendRedirect("m_insert.do");
//		} else if (sPath.equals("/m_deleteOK.do")) {
//			new DeleteOKAction().execute(request, response);
//		}

	}// end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();

		System.out.print("doPost():");
		System.out.println(sPath);
		if (sPath.equals("/insertOK.do")) {
			new InsertOKAction().execute(request, response);;
		} 
	}// end doPost
=======
/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
>>>>>>> 0574ae638d7fa4a00e889ffeb0db092dac3d4166

}
