package test.com.member;

import java.io.File;
import java.io.IOException;
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

/**
 * Servlet implementation class MemberController
 */
@WebServlet({ "/m_insert.do", "/m_insertOK.do", "/m_update.do", "/m_updateOK.do", "/m_delete.do", "/m_deleteOK.do",
		"/m_selectAll.do", "/m_selectOne.do", "/m_searchList.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO dao = new MemberDAOimpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();

		System.out.print("doGet():");
		System.out.println(sPath);

		// test용--> 로그인구현 다 되면 지우기
		HttpSession session = request.getSession(); // 객체 초기화
		session.setMaxInactiveInterval(60);// interval 설정(초단위, 기본은 10~15분)
		session.setAttribute("member_id", "1"); // -> 브라우저 X표 누르기전까지는 session에 저장됨.

		if (sPath.equals("/m_insert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("memberJsp/insert.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/m_selectAll.do")) {
			List<MemberVO> vos = dao.selectAll();
			request.setAttribute("vos", vos);
			RequestDispatcher rd = request.getRequestDispatcher("m_selectAll.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/m_update.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("memberJsp/update.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/m_updateOK.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("m_update.jsp");
			rd.forward(request, response);
		} // else if (sPath.equals("/m_delete.do")) {
//		RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
//		rd.forward(request, response);
		else if (sPath.equals("/m_selectOne.do")) {
			String member_id = (String) session.getAttribute("member_id");
			MemberVO vo = dao.selectOne(member_id);
			request.setAttribute("vo", vo);
			RequestDispatcher rd = request.getRequestDispatcher("m_update.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/m_insertOK.do")) {
			response.sendRedirect("mypage.do");
		}
// else if (sPath.equals("/m_searchList.do")) {
//		new SearchListAction().execute(request, response);
//	} else if (sPath.equals("/m_deleteOK.do")) {
//		new DeleteOKAction().execute(request, response);
//	}

	}// end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		
		HttpSession session = request.getSession(); // 객체 초기화
		session.setAttribute("member_id", "1"); // -> 브라우저 X표 누르기전까지는 session에 저장됨.
		String member_id = String.valueOf(session.getAttribute("member_id"));
		
		String dir_path = request.getServletContext().getRealPath("/upload");
		
		System.out.print("doPost():");
		System.out.println(sPath);
		
		
		if (sPath.equals("/m_insertOK.do")) {
			new InsertOKAction().execute(request, response);
		} else if (sPath.equals("/m_updateOK.do")) {
			String nickname = "";
			String location = "";
			String handy = "";
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
							if (item.getFieldName().equals("location")) {
								location = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("nickname")) {
								nickname = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("handy")) {
								handy = item.getString("UTF-8");
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
			MemberDAO dao = new MemberDAOimpl();

			MemberVO vo = new MemberVO();
			vo.setMember_id(Long.parseLong(member_id));
			vo.setNickname(nickname);
			vo.setLocation(location);
			vo.setHandy(handy);
			vo.setImage_url(image_url);

			int result = dao.update(vo);
			if (result == 1) {
				System.out.println("회원정보수정이 완료.");
				response.sendRedirect("/semi_project/mymeeting_list.do");
			} else {
				System.out.println("회원정보수정이 실패.");
			}

		}
	}// end doPost

}
