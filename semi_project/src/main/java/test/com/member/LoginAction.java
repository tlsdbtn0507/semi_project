package test.com.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.com.notice.NoticeDAO;
import test.com.notice.NoticeDAOimpl;
import test.com.notice.NoticeVO;

public class LoginAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("member_name"));
		System.out.println(request.getParameter("password"));

		MemberDAO dao = new MemberDAOimpl();

		MemberVO vo = new MemberVO();
		vo.setMember_name(request.getParameter("member_name"));
		vo.setPassword(request.getParameter("password"));

		MemberVO vo2 = dao.login(vo);
		System.out.println("login:" + vo2);

		if(vo.getMember_name().equals(vo2.getMember_name())){
			HttpSession session = request.getSession();
			session.setAttribute("member_id", vo2.getMember_id());
		
			session.setAttribute("nickname", vo2.getNickname());
	    	System.out.println(vo2.getMember_id());
	    	System.out.println(vo2.getNickname());
			// 알림
			NoticeDAO noticeDAO = new NoticeDAOimpl();
			noticeDAO.activity_notice(vo2.getMember_id());
			System.out.println("알림 push 완료");
			response.sendRedirect("meeting/meeting.jsp");
		} else {
			response.sendRedirect("login.do");
		}

	}

}
