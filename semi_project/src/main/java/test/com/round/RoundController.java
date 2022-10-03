package test.com.round;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet({ "/main_round_searchList.do", "/main_round_searchListOK.do", "/main_round_selectAll.do",
		"/main_round_insert.do", "/main_round_insertOK.do", "/round_enter.do", "/round_selectOne.do",
		"/round_join_selectOne.do", "/myrounding_list.do" })
public class RoundController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RoundDAO dao = new RoundDAOimpl();

	public RoundController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(); // 객체 초기화
		String member_id = String.valueOf(session.getAttribute("member_id"));

		String sPath = request.getServletPath();
		if (sPath.equals("/main_round_insert.do")) {

			request.getRequestDispatcher("round/insert.jsp").forward(request, response);
		} else if (sPath.equals("/round_selectOne.do")) {
			String round_id = request.getParameter("round_id");

			RoundDAO dao = new RoundDAOimpl();

			// 라운드 유저
			RoundUserVO vo1 = new RoundUserVO();
			vo1.setRound_id(Long.parseLong(round_id));
			vo1.setMember_id(Long.parseLong(member_id));

			RoundVO vo2 = dao.selectOne(vo1);

			request.setAttribute("vo2", vo2);

			response.getWriter().println(vo2.getRound_id());
			response.getWriter().println(vo2.getName());
			response.getWriter().println(vo2.getCourse());
			response.getWriter().println(vo2.getRound_date());
			response.getWriter().println(vo2.getTotal_people());
			response.getWriter().println(vo2.getImage_url());

			request.getRequestDispatcher("round/selectOne.jsp").forward(request, response);

		} else if (sPath.equals("/main_round_selectAll.do")) {

			List<RoundVO> vos = dao.selectAll();
			System.out.println("vos.size():" + vos.size());

			request.setAttribute("vos", vos);

			request.getRequestDispatcher("round/selectAll.jsp").forward(request, response);
		} else if (sPath.equals("/main_round_searchList.do")) {

			request.getRequestDispatcher("round/round_search.jsp").forward(request, response);

		} else if (sPath.equals("/main_round_searchListOK.do")) {

			List<RoundVO> vos = dao.searchList(request.getParameter("searchWord"));

			request.setAttribute("vos", vos);
			request.getRequestDispatcher("round/round_search.jsp").forward(request, response);

		} else if (sPath.equals("/myrounding_list.do")) {

			List<RoundVO> vos = dao.mySelectAll(member_id);

			String txt = "[";
			for (int i=0;i<vos.size();i++) {
				txt += "{\"round_id\":"+vos.get(i).getRound_id()+",";
				txt += "\"name\":\""+vos.get(i).getName()+"\""+",";
				txt += "\"image_url\":\""+vos.get(i).getImage_url()+"\""+"}";
				if(i<vos.size()-1)txt += ",";
			}
			txt += "]";
			PrintWriter out = response.getWriter();
			out.print(txt);
			System.out.println(txt);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dir_path = request.getServletContext().getRealPath("/upload");
		System.out.println(dir_path);

		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();

		long round_id = 0;

		HttpSession session = request.getSession(); // 객체 초기화

		// session에서 member_id를 가져옴.
		String member_id = (String) session.getAttribute("member_id");

		// 메인 라운딩 개설하기 버튼
		if (sPath.equals("/main_round_insertOK.do")) {
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
			RoundDAO dao1 = new RoundDAOimpl();
			RoundDAOimpl dao2 = new RoundDAOimpl();
			RoundVO vo = new RoundVO();

			round_id = dao2.round_id();

			vo.setRound_id(round_id); // nextval 을 따로 씀.
			vo.setName(name);
			vo.setCourse(course);
			vo.setRound_date(round_date);
			vo.setTotal_people(total_people);
			vo.setImage_url(image_url);
			vo.setMember_id(Long.parseLong(member_id));

			System.out.println("round_id" + round_id);
			System.out.println("name" + name);
			System.out.println("image_url" + image_url);
			int result = dao1.insert(vo); // 라운드 개설

			// 라운드 개설 유무 (개설 되었다면 라운드유저에 개설한 유저를 라운드 유저로서 데이터 삽)
			if (result == 1) {
				System.out.println("라운드가 개설되었습니다.");

				RoundDAO dao11 = new RoundDAOimpl();
				RoundUserVO vo2 = new RoundUserVO();

				vo2.setRound_id(round_id);
				System.out.println(round_id);
				vo2.setMember_id(Long.parseLong(member_id));
				System.out.println(member_id);
				vo2.setRole("ROUND_LEADER");

				int result2 = dao11.enter(vo2);

				if (result2 == 1) {
					System.out.println("라운드장이 되었습니다.");
					response.sendRedirect("h_home.do");
				} else {
					System.out.println("라운드장이 될 수 없습니다.");
				}
			} else {
				System.out.println("라운드개설을 실패하였습니다.");
			}

		} else if (sPath.equals("/round_enter.do")) {

			RoundDAO dao = new RoundDAOimpl();

			RoundUserVO vo = new RoundUserVO();
			vo.setRound_id(Long.parseLong(request.getParameter("round_id")));
			// 현재 로그인된 자신의 member_id로 넣어야함.
			vo.setMember_id(Long.parseLong(member_id));
			vo.setRole("ROUND_MEMBER");

			request.setAttribute("vo", vo);
//			RequestDispatcher rd = request.getRequestDispatcher("round/enter.jsp");
//			rd.forward(request, response);

			int result = dao.enter(vo);

			if (result == 1) {
				System.out.println("라운드에 입장하였습니다.");
				response.sendRedirect("myrounding_list.do");
			} else {
				System.out.println("라운드에 입장 실패하였습니다.");

			}
		}
	}

}
