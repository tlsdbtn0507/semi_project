package test.com.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Json_nickCheckAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("nickname"));
	    
		MemberDAO dao = new MemberDAOimpl();
	    MemberVO vo = new MemberVO();
	    vo.setNickname(request.getParameter("nickname"));
		
	    MemberVO vo2 = dao.nickNameCheck(vo);
	    System.out.println("nickNameCheck:"+vo2);
	    
	    
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
