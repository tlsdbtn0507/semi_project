package test.com.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/alarm_selectAll.do", "/alarm_deleteOK.do","/alarm.do" })
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeDAO dao = new NoticeDAOimpl();

	public NoticeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("Get:" + sPath);

		response.setCharacterEncoding("UTF-8");

		// test용--> 로그인구현 다 되면 지우기
		HttpSession session = request.getSession(); // 객체 초기화
		session.setMaxInactiveInterval(60);// interval 설정(초단위, 기본은 10~15분)
		session.setAttribute("member_id", "1"); // -> 브라우저 X표 누르기전까지는 session에 저장됨.

		if (sPath.equals("/alarm_deleteOK.do")) {
			long notice_id = Long.parseLong(request.getParameter("notice_id"));
			int result = dao.delete(notice_id);

			if (result == 1) {
				response.sendRedirect("alarm_selectAll.do");
				System.out.println("삭제가 되었습니다.");
			} else if(result == 0) {
				response.sendRedirect("alarm_selectAll.do");
				System.out.println("삭제가 되지 않았습니다.");
			}
		} else if (sPath.equals("/alarm_selectAll.do")) {
			// session에서 member_id를 가져옴.
			String member_id = (String) session.getAttribute("member_id");
			System.out.println(member_id);
			List<NoticeVO> vos = dao.selectAll("1");
			List<NoticeVO> vos2 = new ArrayList<NoticeVO>();;
			
			for (NoticeVO data : vos) {
				if(data.getContents().contains("초대")) {
					vos2.add(data);
				}
			}
			
			// 일반 알림
			request.setAttribute("vos", vos);
			// 초대 알림
			request.setAttribute("vos2", vos2);
			
			request.getRequestDispatcher("notice/notice_selectAll.jsp").forward(request, response);

		} 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
