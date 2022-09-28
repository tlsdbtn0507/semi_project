package test.com.board;

import java.security.Timestamp;
import java.util.Date;

public class BoardVO {
	private long board_id; // 게시판 번호 
	private int meeting_id;
	private String title;
	private String contents;
	private String writer;
	private String notice;
	private Date wdate;
	private int member_id;
	
	
	
	
	public int getMember_id() {
		return member_id;
	}


	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}


	public BoardVO() {
		// TODO Auto-generated constructor stub
	}


	public long getBoard_id() {
		return board_id;
	}


	public void setBoard_id(long board_id) {
		this.board_id = board_id;
	}


	public int getMeeting_id() {
		return meeting_id;
	}


	public void setMeeting_id(int meeting_id) {
		this.meeting_id = meeting_id;
	}




	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getNotice() {
		return notice;
	}


	public void setNotice(String notice) {
		this.notice = notice;
	}


	public Date getWdate() {
		return wdate;
	}


	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}


	public BoardVO(long board_id, int meeting_id, String title, String contents, String writer,
			String notice, Date wdate) {
		super();
		this.board_id = board_id;
		this.meeting_id = meeting_id;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.notice = notice;
		this.wdate = wdate;
	}


	
	
	
	
	
	
	
	
	
}
