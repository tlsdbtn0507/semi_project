package test.com.notice;

public class NoticeVO {
	private long notice_id; // 알림 번호
	private String contents; // 알림 내용
	private long member_id;
	private long meeting_id;

	public NoticeVO() {
		// TODO Auto-generated constructor stub
	}

	public NoticeVO(long notice_id, String contents, long member_id, long meeting_id) {
		super();
		this.notice_id = notice_id;
		this.contents = contents;
		this.member_id = member_id;
		this.meeting_id = meeting_id;
	}

	public NoticeVO(String contents, long member_id, long meeting_id) {
		super();
		this.contents = contents;
		this.member_id = member_id;
		this.meeting_id = meeting_id;
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

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public long getMeeting_id() {
		return meeting_id;
	}

	public void setMeeting_id(long meeting_id) {
		this.meeting_id = meeting_id;
	}

}
