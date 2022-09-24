package test.com.meeting;

public class MeetingUserVO {
	long meeting_user_id;
	long member_id;
	String role;
	// fk
	long meeting_id;
	
	public MeetingUserVO() {
		// TODO Auto-generated constructor stub
	}

	public MeetingUserVO(long meeting_user_id, long member_id, String role, long meeting_id) {
		super();
		this.meeting_user_id = meeting_user_id;
		this.member_id = member_id;
		this.role = role;
		this.meeting_id = meeting_id;
	}

	public long getMeeting_user_id() {
		return meeting_user_id;
	}

	public void setMeeting_user_id(long meeting_user_id) {
		this.meeting_user_id = meeting_user_id;
	}

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getMeeting_id() {
		return meeting_id;
	}

	public void setMeeting_id(long meeting_id) {
		this.meeting_id = meeting_id;
	}
	
	
}
