package test.com.round;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

@WebServlet({ "/main_round_searchList.do", "/main_round_selectAll.do","/main_round_insert.do","/main_round_insertOK.do",
	"/round_selectOne.do","/myrounding_list.do"})
public class RoundController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RoundDAO dao = new RoundDAOimpl();

	public RoundController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		if (sPath.equals("/main_round_insert.do")) {

			request.getRequestDispatcher("round/insert.jsp").forward(request, response);
		}else if(sPath.equals("/round_selectOne.do")) {
			String round_id = request.getParameter("round_id");
			
			RoundDAO dao = new RoundDAOimpl();
			
			RoundVO vo = new RoundVO();
			vo.setRound_id(Long.parseLong(round_id));
			
			RoundVO vo2 = dao.selectOne(vo);
			
			request.setAttribute("vo2", vo2);
			
			response.getWriter().print(vo2.getRound_id());
			response.getWriter().print(vo2.getName());
			response.getWriter().print(vo2.getCourse());
			response.getWriter().print(vo2.getRound_date());
			response.getWriter().print(vo2.getTotal_people());
			response.getWriter().print(vo2.getImage_url());
//			RequestDispatcher rd = request.getRequestDispatcher("round/selectOne.jsp");
//			rd.forward(request, response);
		}
		else if (sPath.equals("/main_round_selectAll.do")) {

			List<RoundVO> vos = dao.selectAll();
			System.out.println("vos.size():" + vos.size());

			request.setAttribute("vos", vos);

			request.getRequestDispatcher("round/selectAll.jsp").forward(request, response);
		} else if (sPath.equals("/main_round_searchList.do")) {

			List<RoundVO> vos = dao.searchList(request.getParameter("searchKey"), request.getParameter("searchWord"));

			request.setAttribute("vos", vos);

			request.getRequestDispatcher("round/selectAll.jsp").forward(request, response);
		} else if(sPath.equals("/myrounding_list.do")) {
			
			//test용--> 로그인구현 다 되면 지우기
			HttpSession session = request.getSession(); //객체 초기화
			session.setMaxInactiveInterval(60);//interval 설정(초단위, 기본은 10~15분)
			session.setAttribute("member_id", "1"); //-> 브라우저 X표 누르기전까지는 session에 저장됨.
			//session에서 member_id를 가져옴.
			String member_id = (String) session.getAttribute("member_id");
			
			List<RoundVO> vos = dao.mySelectAll(member_id);
			//json으로 반환
//			PrintWriter out = response.getWriter();
//			out.print(vos.toString());
			request.setAttribute("vos",vos);
			request.getRequestDispatcher("r_selectAll.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String dir_path = request.getServletContext().getRealPath("/upload");
		System.out.println(dir_path);
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		
		if(sPath.equals("/main_round_insertOK.do")) {
			// 앞단에서 달력 눌렀을때 데이터 포맷 형태에 따라 달라질 수 있다.
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			Date date;
			// 쌍따옴표가 들어가서 cut 시켜줌.
//			String str = request.getParameter("round_date").substring(1, 11);
//			try {
//				date = format.parse(str);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
			String name = "";
			String course = "";
			String round_date = "";
			int total_people = 0;
			String image_url = "";

			int fileSizeMax = 1024 * 1024 * 100;
			boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
			
			if (isMultipartContent) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(fileSizeMax);
				ServletFileUpload sfu = new ServletFileUpload(factory);
				sfu.setFileSizeMax(fileSizeMax);// 파일 사이즈 제한

				try {
					List<FileItem> items = sfu.parseRequest(request);
					for (FileItem item : items) {
						if (item.isFormField()) { // name,id 받기
							if (item.getFieldName().equals("name")) {
								name = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("course")) {
								course = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("round_date")) {
								round_date = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("total_people")) {
								total_people = Integer.parseInt(item.getString("UTF-8"));
							}
						} else { // file정보받기.

							image_url = FilenameUtils.getName(item.getName());
//							image_url += "/"+id;
							// 다른사람이 같은 이름으로 저장했을때, 덮어써질 수 있으므로 unique한 id나 system time 같이 저장.

							File saveFile = new File(dir_path, image_url);

							try {
								item.write(saveFile);
							} catch (Exception e) {
								e.printStackTrace();
							}

						} // end else

					} // end for << items
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
			}
			RoundDAO dao = new RoundDAOimpl();
			RoundVO vo = new RoundVO();
			
			vo.setName(name);
			vo.setCourse(course);
			vo.setRound_date(round_date);
			vo.setTotal_people(total_people);
			vo.setImage_url(image_url);
			
			int result = dao.insert(vo);

			if (result == 1) {
				System.out.println("라운드가 개설되었습니다.");
			} else {
				System.out.println("라운드개설을 실패하였습니다.");
			}
		}
	}

}
