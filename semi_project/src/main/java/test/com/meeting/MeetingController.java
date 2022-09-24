package test.com.meeting;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

import test.com.round.RoundDAO;
import test.com.round.RoundDAOimpl;
import test.com.round.RoundVO;

@WebServlet({ "/main_meeting_selectAll.do", "/main_meeting_searchList.do", "/main_meeting_insert.do",
		"/main_meeting_insertOK.do","/mymeeting_list.do" })
public class MeetingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MeetingController() {
		super();
	}

	MeetingDAO dao = new MeetingDAOimpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		if (sPath.equals("/main_round_insert.do")) {

			request.getRequestDispatcher("meeting/insert.jsp").forward(request, response);
		} else if (sPath.equals("/main_meeting_selectAll.do")) {

			List<MeetingVO> vos = dao.selectAll();
			System.out.println("vos.size():" + vos.size());

			request.setAttribute("vos", vos);

			request.getRequestDispatcher("meeting/selectAll.jsp").forward(request, response);
		} else if (sPath.equals("/main_meeting_searchList.do")) {

			List<MeetingVO> vos = dao.searchList(request.getParameter("searchKey"), request.getParameter("searchWord"));

			request.setAttribute("vos", vos);
//			System.out.println(vos.get(0).getName());

			request.getRequestDispatcher("meeting/selectAll.jsp").forward(request, response);
		}else if(sPath.equals("/mymeeting_list.do")) {
			
			//test용--> 로그인구현 다 되면 지우기
			HttpSession session = request.getSession(); //객체 초기화
			session.setMaxInactiveInterval(60);//interval 설정(초단위, 기본은 10~15분)
			session.setAttribute("member_id", "1"); //-> 브라우저 X표 누르기전까지는 session에 저장됨.
			//session에서 member_id를 가져옴.
			String member_id = (String) session.getAttribute("member_id");
			
			List<MeetingVO> vos = dao.mySelectAll(member_id);
			//json으로 반환
//			PrintWriter out = response.getWriter();
//			out.print(vos.toString());
			request.setAttribute("vos",vos);
			request.getRequestDispatcher("selectAll.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dir_path = request.getServletContext().getRealPath("/upload");
		System.out.println(dir_path);
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		
		// session
		HttpSession session = request.getSession();
		session.setAttribute("member_id", "1");
		String member_id = (String) session.getAttribute("member_id"); //member_name 
		
		if (sPath.equals("/main_meeting_insertOK.do")) {

			String name = "";
			String explanation = "";
			String gender = "";
			String age = "";
			String location = "";
			String permission = "";
			String secret = "";
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
							if (item.getFieldName().equals("explanation")) {
								explanation = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("gender")) {
								gender = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("age")) {
								age = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("location")) {
								location = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("permission")) {
								permission = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("secret")) {
								secret = item.getString("UTF-8");
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
			MeetingDAO dao = new MeetingDAOimpl();
			MeetingVO vo = new MeetingVO();

			vo.setName(name);
			vo.setExplanation(explanation);
			vo.setGender(gender);
			vo.setAge(age);
			vo.setLocation(location);
			vo.setPermission(permission);
			vo.setSecret(secret);
			vo.setTotal_people(total_people);
			vo.setImage_url(image_url);
//			vo.setMember_id(1); 
			vo.setMember_id(Long.parseLong(member_id)); 
			
			int result = dao.insert(vo);

			if (result == 1) {
				System.out.println("모임이 개설되었습니다.");
			} else {
				System.out.println("모임개설을 실패하였습니다.");
			}
		}
	}

}
