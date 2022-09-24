package test.com.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Json_idCheckAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("id"));
	    
		MemberDAO dao = new MemberDAOimpl();
	    MemberVO vo = new MemberVO();
	    vo.setMember_name(request.getParameter("id"));
		
	    MemberVO vo2 = dao.idCheck(vo);
	    System.out.println("idCheck:"+vo2);
	    
	    
	    response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Credentials", "true");
	    
	    PrintWriter out = response.getWriter();
	    if(vo2 != null){
	    	out.print("{\"result\":\"Not OK\"}");
	    }else{
	    	out.print("{\"result\":\"OK\"}");
	    }
	}

}
