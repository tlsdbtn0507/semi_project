package test.com.activity;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import test.com.meeting.MeetingVO;

@WebServlet({ "/myactivity_list.do", "/main_activity_selectAll.do", "/recommend_activity_selectAll.do",
		"/imminent_activity_selectAll.do", "/meeting_activity_selectAll.do",
		"/activity_insert.do","/activity_insertOK.do","/activity_enter.do"})

public class ActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActivityDAO dao = new ActivityDAOimpl();

	public ActivityController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet:" + sPath);
		response.setCharacterEncoding("UTF-8"); // UTF-8형식으로 바꿔주기

		// test용--> 로그인구현 다 되면 지우기
		HttpSession session = request.getSession(); // 객체 초기화
		session.setMaxInactiveInterval(60);// interval 설정(초단위, 기본은 10~15분)
		session.setAttribute("member_id", "1"); // -> 브라우저 X표 누르기전까지는 session에 저장됨.

		if (sPath.equals("/myactivity_list.do")) {
			// session에서 member_id를 가져옴.
			String member_id = (String) session.getAttribute("member_id");
			// activityStatus(활동전,활동중,활동후)
			String activityState = request.getParameter("activityState");
			System.out.println("activityState:" + activityState);
			List<ActivityVO> vos = dao.mySelectAll(member_id, activityState);
			// json으로 반환
//			PrintWriter out = response.getWriter();
//			out.print(vos.toString());
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("a_selectAll.jsp").forward(request, response);
		} else if (sPath.equals("/main_activity_selectAll.do")) {
			List<ActivityVO> vos = dao.selectAll();
			// json으로 반환
//			PrintWriter out = response.getWriter();
//			out.print(vos.toString());
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("a_selectAll.jsp").forward(request, response);
		} else if (sPath.equals("/recommend_activity_selectAll.do")) {
			// session에서 member_id를 가져옴.
			String member_id = (String) session.getAttribute("member_id");
			// category(또래끼리,성별끼리,실력이 비슷한,내 근처의 )
			String category = request.getParameter("category");
			System.out.println(member_id);
			System.out.println(category);
			List<ActivityVO> vos = dao.recommendSelectAll(member_id, category);
			// json으로 반환
			String txt = "[";
			for (int i=0;i<vos.size();i++) {
				txt += "{\"activity_id\":"+vos.get(i).getActivity_id()+",";
				txt += "\"name\":\""+vos.get(i).getName()+"\""+",";
				txt += "\"activity_date\":\""+vos.get(i).getActivity_date()+"\""+",";
				txt += "\"activity_time\":\""+vos.get(i).getActivity_time()+"\""+",";
				txt += "\"location\":\""+vos.get(i).getLocation()+"\""+",";
				txt += "\"total_people\":\""+vos.get(i).getTotal_people()+"\""+",";
				txt += "\"current_people\":\""+vos.get(i).getCurrent_people()+"\""+",";
				txt += "\"image_url\":\""+vos.get(i).getImage_url()+"\""+"}";
				if(i<vos.size()-1)txt += ",";
			}
			txt += "]";
			PrintWriter out = response.getWriter();
			out.print(txt);
			System.out.println(txt);
		} else if (sPath.equals("/imminent_activity_selectAll.do")) {
			// session에서 member_id를 가져옴.
			String member_id = (String) session.getAttribute("member_id");
			// category(또래끼리,성별끼리,실력이 비슷한,내 근처의 )
			List<ActivityVO> vos = dao.imminentSelectAll(member_id);
			// json으로 반환
/// json으로 반환
			String txt = "[";
			for (int i=0;i<vos.size();i++) {
				txt += "{\"activity_id\":"+vos.get(i).getActivity_id()+",";
				txt += "\"name\":\""+vos.get(i).getName()+"\""+",";
				txt += "\"activity_date\":\""+vos.get(i).getActivity_date()+"\""+",";
				txt += "\"activity_time\":\""+vos.get(i).getActivity_time()+"\""+",";
				txt += "\"location\":\""+vos.get(i).getLocation()+"\""+",";
				txt += "\"total_people\":\""+vos.get(i).getTotal_people()+"\""+",";
				txt += "\"current_people\":\""+vos.get(i).getCurrent_people()+"\""+",";
				txt += "\"image_url\":\""+vos.get(i).getImage_url()+"\""+"}";
				if(i<vos.size()-1)txt += ",";
			}
			txt += "]";
			PrintWriter out = response.getWriter();
			out.print(txt);
			System.out.println(txt);
		} else if (sPath.equals("/meeting_activity_selectAll.do")) {
			
			MeetingVO vo2 = new MeetingVO();
			vo2.setMeeting_id(Long.parseLong(request.getParameter("meeting_id")));

			List<ActivityVO> vos_ma = dao.inSelectAll(vo2);

//			request.setAttribute("vos_ma",vos_ma); 
//			request.getRequestDispatcher("meeting/activity_selectAll.jsp").forward(request, response);
			
			for (ActivityVO data : vos_ma) {
				response.getWriter().println(data.getMeeting_id());
				response.getWriter().println(data.getActivity_id());
				response.getWriter().println(data.getName());
				response.getWriter().println(data.getExplanation());
				response.getWriter().println(data.getActivity_date());
				response.getWriter().println(data.getActivity_time());
				response.getWriter().println(data.getImage_url());
				response.getWriter().println(data.getTotal_people());
				response.getWriter().println(data.getCurrent_people());
			}
		}
		else if(sPath.equals("/activity_insert.do")) {
			System.out.println("activity/insert.jsp 입장");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String dir_path = request.getServletContext().getRealPath("/upload");
		System.out.println(dir_path);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();

		long activity_id = 0l;
		
		// session
		HttpSession session = request.getSession();
		session.setAttribute("member_id", "1");
		String member_id = (String) session.getAttribute("member_id"); // member_name

		if (sPath.equals("/activity_insertOK.do")) {
			// 현재 시간 구하기
			SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
			Date now = new Date();         
		
			String name = "";
			String explanation = "";
			String activity_date = "";
			String activity_time = "";
			String location = "";
			int total_people = 0;
			String image_url = "";
//			String creation_date = date_format.format(now);

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
							if (item.getFieldName().equals("activity_date")) {
								activity_date = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("activity_time")) {
								activity_time = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("location")) {
								location = item.getString("UTF-8");
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
			ActivityDAO dao = new ActivityDAOimpl();
			ActivityDAOimpl dao2 = new ActivityDAOimpl();
			ActivityVO vo = new ActivityVO();
			
			activity_id = dao2.activity_id();
			System.out.println("activity_id 값 : " + activity_id);
			
			vo.setActivity_id(activity_id);
			vo.setName(name);
			vo.setExplanation(explanation);
			vo.setActivity_date(activity_date);
			vo.setActivity_time(activity_time);
			vo.setLocation(location);
			vo.setTotal_people(total_people);
			vo.setMember_id(Long.parseLong(member_id));
			vo.setMeeting_id(Long.parseLong(request.getParameter("meeting_id")));
			vo.setImage_url(image_url);

			int result = dao.insert(vo);

			if (result == 1) {
				System.out.println("액티비티가 개설되었습니다.");
				
				ActivityUserVO vo2 = new ActivityUserVO();
				
				vo2.setActivity_id(activity_id);
				vo2.setMeeting_id(Long.parseLong(request.getParameter("meeting_id")));
				System.out.println("activity_id 값  : " + activity_id);
				vo2.setMember_id(Long.parseLong(member_id));
				vo2.setRole("ACTIVITY_LEADER");
				int result2 = dao.enter(vo2);

				if (result2 == 1) {
					System.out.println("액티비티장이 되었습니다.");
				} else {
					System.out.println("액티비티장이 될 수 없습니다.");
				}
				
			} else {
				System.out.println("액티비티개설을 실패하였습니다.");
			}
		}else if(sPath.equals("/activity_enter.do")) {
			
			ActivityDAO dao22 = new ActivityDAOimpl();

			ActivityUserVO vo = new ActivityUserVO();
			vo.setActivity_id(activity_id);
			vo.setMeeting_id(Long.parseLong(request.getParameter("meeting_id")));
			// 현재 로그인된 자신의 member_id로 넣어야함.
			vo.setMember_id(Long.parseLong(member_id));
			vo.setRole("ACTIVITY_MEMBER");
			int result = dao22.enter(vo);

			if (result == 1) {
				System.out.println("액티비티에 입장하였습니다.");
			} else {
				System.out.println("액티비티에 입장 실패하였습니다.");
			}
		}
		
	}

}
