package test.com.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class InsertOKAction {
	
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String nick = "";
		String id = "";
		String pw = "";
		String age = "";
		String handy = "";
		String loc = "";
		String gender = "";
		
		String dir_path = 
				request.getServletContext()
				.getRealPath("/upload");
		System.out.println(dir_path);

		
		int fileSizeMax = 1024 * 1024 * 100;

		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);

		if(isMultipartContent) {
			DiskFileItemFactory factory = 
					new DiskFileItemFactory();
			factory.setSizeThreshold(fileSizeMax);
			
			ServletFileUpload sfu = 
					new ServletFileUpload(factory);
			sfu.setFileSizeMax(fileSizeMax);//파일 사이즈 제한

			
			
			try {
				List<FileItem> items = 
						sfu.parseRequest(request);
				for (FileItem item : items) {
					if (item.isFormField()) { //id,pw,name,tel 받기
						if(item.getFieldName().equals("nick")) {
							nick = item.getString("UTF-8");
						}
						if(item.getFieldName().equals("id")) {
							id = item.getString("UTF-8");
						}
						if(item.getFieldName().equals("pw")) {
							pw = item.getString("UTF-8");
						}
						if(item.getFieldName().equals("age")) {
							age = item.getString("UTF-8");
						}
						if(item.getFieldName().equals("handy")) {
							handy = item.getString("UTF-8");
						}
						if(item.getFieldName().equals("loc")) {
							loc = item.getString("UTF-8");
						}
						if(item.getFieldName().equals("gender")) {
							gender = item.getString("UTF-8");
						}
					}
					

						


				}//end for << items
			} catch (FileUploadException e) {
				e.printStackTrace();
			}


		}//end if << isMultilpart
		System.out.println("id:"+id);
		System.out.println("pw:"+pw);
		System.out.println("name:"+nick);
//		System.out.println("tel:"+tel);
//		System.out.println("img_name:"+img_name);
		
		
		MemberVO vo = new MemberVO();
		vo.setNickname(nick);
		vo.setMember_name(id);
		vo.setPassword(pw);
		vo.setAge(age);
		vo.setHandy(handy);
		vo.setLocation(loc);
		vo.setGender(gender);
		
		MemberDAO dao = new MemberDAOimpl();
		int result = dao.insert(vo);
		System.out.println("result:" + result);
		
		if(result==1)
			response.sendRedirect("login.do");
		else
			response.sendRedirect("m_insert.do");
	}

}
