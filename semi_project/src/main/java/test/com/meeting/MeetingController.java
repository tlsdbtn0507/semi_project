package test.com.meeting;

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

@WebServlet({ "/main_meeting_selectAll.do", "/main_meeting_searchList.do", "/main_meeting_searchListOK.do",
		"/main_meeting_insert.do", "/main_meeting_insertOK.do", "/meeting_selectOne.do", "/mymeeting_list.do",
		"/main_mymeeting_list.do", "/meeting_enter.do", "/meeting_update.do", "/meeting_updateOK.do" })

public class MeetingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MeetingController() {
		super();
	}

	MeetingDAO dao = new MeetingDAOimpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); // UTF-8형식으로 바꿔주기

		HttpSession session = request.getSession(); // 객체 초기화

		String member_id = String.valueOf(session.getAttribute("member_id"));
		String sPath = request.getServletPath();

		if (sPath.equals("/main_meeting_insert.do")) {

			request.getRequestDispatcher("meeting/meeting_insert.jsp").forward(request, response);
		} else if (sPath.equals("/meeting_selectOne.do")) {
			String meeting_id = request.getParameter("meeting_id");
			System.out.println(meeting_id);

			MeetingDAO dao = new MeetingDAOimpl();

			// 모임 유저
			MeetingUserVO vo = new MeetingUserVO();
			vo.setMeeting_id(Long.parseLong(meeting_id));
			vo.setMember_id(Long.parseLong(member_id));

			MeetingVO vo2 = dao.selectOne(vo);

			request.setAttribute("vo2", vo2);

			request.getRequestDispatcher("meeting/meeting.jsp").forward(request, response);

		} else if (sPath.equals("/main_meeting_selectAll.do")) {

			List<MeetingVO> vos = dao.selectAll();
			System.out.println("vos.size():" + vos.size());

			request.setAttribute("vos", vos);

			request.getRequestDispatcher("meeting/selectAll.jsp").forward(request, response);
		} else if (sPath.equals("/main_meeting_searchList.do")) {

			request.getRequestDispatcher("meeting/meeting_search.jsp").forward(request, response);
		} else if (sPath.equals("/main_meeting_searchListOK.do")) {

			MeetingVO vo = new MeetingVO();
			vo.setLocation(request.getParameter("location"));
			vo.setGender(request.getParameter("gender"));
			vo.setAge(request.getParameter("age"));

			List<MeetingVO> vos = dao.searchList(vo, request.getParameter("searchWord"));
			System.out.println("vos.size():" + vos.size());

			request.setAttribute("vos", vos);

//			response.getWriter().println(vos.get(0).getName());
//			System.out.println(vos.get(0).getName());

			request.getRequestDispatcher("meeting/meeting_search.jsp").forward(request, response);
		} else if (sPath.equals("/main_mymeeting_list.do")) {

			List<MeetingVO> vos = dao.mySelectAll(member_id);

			System.out.println(member_id);
			String txt = "[";
			for (int i = 0; i < vos.size(); i++) {
				txt += "{\"meeting_id\":" + vos.get(i).getMeeting_id() + ",";
				txt += "\"name\":\"" + vos.get(i).getName() + "\"" + ",";
				txt += "\"image_url\":\"" + vos.get(i).getImage_url() + "\"" + "}";
				if (i < vos.size() - 1)
					txt += ",";
			}
			txt += "]";
			PrintWriter out = response.getWriter();
			out.print(txt);
			System.out.println(txt);
		} else if (sPath.equals("/mymeeting_list.do")) {

			List<MeetingVO> vos = dao.selectAll();
			System.out.println("vos.size():" + vos.size());

			request.setAttribute("vos", vos);
			request.getRequestDispatcher("mypage/mymeeting.jsp").forward(request, response);
		} else if (sPath.equals("/recommend_meeting_selectAll.do")) {

			List<MeetingVO> vos = dao.recommendSelectAll(member_id);
			System.out.println(member_id);
			String txt = "[";
			for (int i = 0; i < vos.size(); i++) {
				txt += "{\"meeting_id\":" + vos.get(i).getMeeting_id() + ",";
				txt += "\"name\":\"" + vos.get(i).getName() + "\"" + ",";
				txt += "\"image_url\":\"" + vos.get(i).getImage_url() + "\"" + "}";
				if (i < vos.size() - 1)
					txt += ",";
			}
			txt += "]";
			PrintWriter out = response.getWriter();
			out.print(txt);
			System.out.println(txt);
		} else if (sPath.equals("/meeting_invite.do")) {

			List<MeetingVO> vos = dao.mySelectAll(member_id);
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("mypage/mymeeting.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dir_path = request.getServletContext().getRealPath("/upload");
		System.out.println(dir_path);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();

		long meeting_id = 0l;

		// session
		HttpSession session = request.getSession();
		session.setAttribute("member_id", "1");
		String member_id = (String) session.getAttribute("member_id"); // member_name

		if (sPath.equals("/main_meeting_insertOK.do")) {
			// 현재 시간 구하기
			SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
			Date now = new Date();

			String name = "";
			String explanation = "";
			String gender = "";
			String age = "";
			String location = "";
			String permission = "";
			String secret = "";
			String handy = "";
			int total_people = 0;
			String image_url = "";
			String creation_date = date_format.format(now);

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
							if (item.getFieldName().equals("handy")) {
								handy = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("total_people")) {
								total_people = Integer.parseInt(item.getString("UTF-8"));
							}
							if (item.getFieldName().equals("creation_date")) {
								creation_date = item.getString("UTF-8");
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
			MeetingDAOimpl dao2 = new MeetingDAOimpl();
			MeetingVO vo = new MeetingVO();

			meeting_id = dao2.meeting_id();
			System.out.println("meeting_id 값 : " + meeting_id);

			vo.setMeeting_id(meeting_id);
			vo.setName(name);
			vo.setExplanation(explanation);
			vo.setGender(gender);
			vo.setAge(age);
			vo.setHandy(handy);
			vo.setLocation(location);
			vo.setPermission(permission);
			vo.setSecret(secret);
			vo.setTotal_people(total_people);
			vo.setImage_url(image_url);
//			vo.setMember_id(1); 
			vo.setMember_id(Long.parseLong(member_id));
			vo.setCreation_date(creation_date);

			int result = dao.insert(vo);

			if (result == 1) {
				System.out.println("모임이 개설되었습니다.");

				MeetingUserVO vo2 = new MeetingUserVO();

				vo2.setMeeting_id(meeting_id);
				System.out.println("meeting_id 값  : " + meeting_id);
				// 현재 로그인된 자신의 member_id로 넣어야함.
				vo2.setMember_id(Long.parseLong(member_id));
				vo2.setRole("MEETING_LEADER");
				int result2 = dao.enter(vo2);

				if (result2 == 1) {
					System.out.println("모임장이 되었습니다.");
					response.sendRedirect("meeting_selectOne.do?meeting_id="+meeting_id);
				} else {
					System.out.println("모임장이 될 수 없습니다.");
					response.sendRedirect("main_meeting_insert.do");
				}

			} else {
				System.out.println("모임개설을 실패하였습니다.");
			}
		} else if (sPath.equals("/meeting_enter.do")) {

			MeetingDAO dao22 = new MeetingDAOimpl();

			MeetingUserVO vo = new MeetingUserVO();
			vo.setMeeting_id(Long.parseLong(request.getParameter("meeting_id")));
			// 현재 로그인된 자신의 member_id로 넣어야함.
			vo.setMember_id(Long.parseLong(member_id));
			vo.setRole("MEETING_MEMBER");
			int result = dao22.enter(vo);

			if (result == 1) {
				System.out.println("모임에 입장하였습니다.");
			} else {
				System.out.println("모임에 입장 실패하였습니다.");
			}
		} else if (sPath.equals("/meeting_updateOK.do")) {

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
							image_url += "/" + member_id;
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
			vo.setMeeting_id(Long.parseLong(request.getParameter("meeting_id")));
			vo.setName(name);
			vo.setExplanation(explanation);
			vo.setGender(gender);
			vo.setAge(age);
			vo.setLocation(location);
			vo.setPermission(permission);
			vo.setSecret(secret);
			vo.setTotal_people(total_people);
			vo.setImage_url(image_url);

			System.out.println(name + " " + total_people);

			int result = dao.update(vo);
			if (result == 1) {
				System.out.println("모임정보수정이 완료.");
			} else {
				System.out.println("모임정보수정이 실패.");
			}
		}
	}

}
