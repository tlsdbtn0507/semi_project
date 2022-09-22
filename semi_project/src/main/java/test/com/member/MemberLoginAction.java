package test.com.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MemberLoginAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("userID"));
		System.out.println(request.getParameter("userPW"));
	    
		MemberDAO dao = new MemberDAOimpl();
	    MemberVO vo = new MemberVO();
	    vo.setMember_name(request.getParameter("userID"));
	    vo.setPassword(request.getParameter("userPW"));
		
	    MemberVO vo2 = dao.login(vo);
	    System.out.println("login:"+vo2);
	    
	    if(vo2 != null){
	    	HttpSession session = request.getSession();
			session.setAttribute("user_id", vo2.getMember_name());
	    	response.sendRedirect("home.do");
	    }else{
	    	response.sendRedirect("login.do");
	    }
	}

}
