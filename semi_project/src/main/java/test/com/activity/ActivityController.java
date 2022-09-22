package test.com.activity;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ActivityController
 */
@WebServlet("/myactivity_list.do")
public class ActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActivityDAO dao = new ActivityDAOimpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet:"+sPath);
		if(sPath.equals("/myactivity_list.do")) {
			
			//test용--> 로그인구현 다 되면 지우기
			HttpSession session = request.getSession(); //객체 초기화
			session.setMaxInactiveInterval(60);//interval 설정(초단위, 기본은 10~15분)
			session.setAttribute("member_id", "1"); //-> 브라우저 X표 누르기전까지는 session에 저장됨.
			//session에서 member_id를 가져옴.
			String member_id = (String) session.getAttribute("member_id");
			//activityStatus(활동전,활동중,활동후)
			String activityState = request.getParameter("activityState");
			System.out.println("activityState:"+activityState);
			List<ActivityVO> vos = dao.mySelectAll(member_id, activityState);
			//json으로 반환
//			PrintWriter out = response.getWriter();
//			out.print(vos.toString());
			request.setAttribute("vos",vos);
			request.getRequestDispatcher("a_selectAll.jsp").forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
