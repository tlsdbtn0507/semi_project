package test.com.notice;

public class NoticeVO {
	private long notice_id; // 알림 번호 
	private String contents;  // 알림 내용
	
	public NoticeVO() {
		// TODO Auto-generated constructor stub
	}

	public NoticeVO(long notice_id, String contents) {
		super();
		this.notice_id = notice_id;
		this.contents = contents;
	}

	public long getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(long notice_id) {
		this.notice_id = notice_id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
}
