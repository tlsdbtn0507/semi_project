package test.com.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("member_name"));
		System.out.println(request.getParameter("password"));
	    
		MemberDAO dao = new MemberDAOimpl();
	    MemberVO vo = new MemberVO();
	    vo.setMember_name(request.getParameter("member_name"));
	    vo.setPassword(request.getParameter("password"));
		
	    MemberVO vo2 = dao.login(vo);
	    System.out.println("login:"+vo2);
	    
	    if(vo2 != null){
	    	HttpSession session = request.getSession();
			session.setAttribute("member_name", vo2.getMember_name());
	    	response.sendRedirect("meeting.jsp");
	    }else{
	    	response.sendRedirect("login.do");
	    }
	}

}
