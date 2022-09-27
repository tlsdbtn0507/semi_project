package test.com.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class MemberController
 */
@WebServlet({ "/m_insert.do", "/insertOK.do", "/m_update.do", "/m_updateOK.do", "/m_delete.do", "/m_deleteOK.do",
	"/m_selectAll.do", "/m_selectOne.do", "/m_searchList.do" })
public class MemberController extends HttpServlet {
private static final long serialVersionUID = 1L;
private MemberDAO dao = new MemberDAOimpl();

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

	// test용--> 로그인구현 다 되면 지우기
	HttpSession session = request.getSession(); // 객체 초기화
	session.setMaxInactiveInterval(60);// interval 설정(초단위, 기본은 10~15분)
	session.setAttribute("member_id", "1"); // -> 브라우저 X표 누르기전까지는 session에 저장됨.

	if (sPath.equals("/m_insert.do")) {
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		rd.forward(request, response);
	} else if (sPath.equals("/m_selectAll.do")) {
		List<MemberVO> vos = dao.selectAll();
		request.setAttribute("vos", vos);
		RequestDispatcher rd = request.getRequestDispatcher("m_selectAll.jsp");
		rd.forward(request, response);
	} else if (sPath.equals("/m_update.do")) {
		RequestDispatcher rd = request.getRequestDispatcher("m_update.jsp");
		rd.forward(request, response);
	} else if (sPath.equals("/m_updateOK.do")) {
		RequestDispatcher rd = request.getRequestDispatcher("m_update.jsp");
		rd.forward(request, response);
	} // else if (sPath.equals("/m_delete.do")) {
//		RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
//		rd.forward(request, response);
	else if (sPath.equals("/m_selectOne.do")) {
		String member_id = (String) session.getAttribute("member_id");
		MemberVO vo = dao.selectOne(member_id);
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("m_update.jsp");
		rd.forward(request, response);
	} // else if (sPath.equals("/m_searchList.do")) {
//		new SearchListAction().execute(request, response);
//	} else if (sPath.equals("/m_insertOK.do")) {
//		response.sendRedirect("m_insert.do");
//	} else if (sPath.equals("/m_deleteOK.do")) {
//		new DeleteOKAction().execute(request, response);
//	}

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

}
