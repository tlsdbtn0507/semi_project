package test.com.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet({ "/alarm_selectAll.do", "/alarm_deleteOK.do" })
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeDAO dao = new NoticeDAOimpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeController() {
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
		System.out.println("Get:" + sPath);

		// test용--> 로그인구현 다 되면 지우기
		HttpSession session = request.getSession(); // 객체 초기화
		session.setMaxInactiveInterval(60);// interval 설정(초단위, 기본은 10~15분)
		session.setAttribute("member_id", "1"); // -> 브라우저 X표 누르기전까지는 session에 저장됨.

		if (sPath.equals("/alarm_deleteOK.do")) {
			long notice_id = Integer.parseInt(request.getParameter("num"));
			int result = dao.delete(notice_id);

			if (result == 1)
				response.sendRedirect("alarm_selectAll.do");
			else // 음... 없어도 될 것 같은디...
				response.sendRedirect("alarm_selectAll.do");
		} else if (sPath.equals("/alarm_selectAll.do")) {
			// session에서 member_id를 가져옴.
			String member_id = (String) session.getAttribute("member_id");
			// category(또래끼리,성별끼리,실력이 비슷한,내 근처의 )
			String category = request.getParameter("category");
			System.out.println(member_id);
			System.out.println(category);
			List<NoticeVO> vos = dao.selectAll(member_id);

			request.setAttribute("vos", vos);
			request.getRequestDispatcher("alarm_selectAll.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
