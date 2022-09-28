package test.com.activity;

public class ActivityUserVO {
	long activity_user_id;
	long activity_id;
	long meeting_id;
	long member_id;
	String role; // 권한
	
	public ActivityUserVO() {
		// TODO Auto-generated constructor stub
	}

	public ActivityUserVO(long activity_user_id, long activity_id, long meeting_id, long member_id, String role) {
		super();
		this.activity_user_id = activity_user_id;
		this.activity_id = activity_id;
		this.meeting_id = meeting_id;
		this.member_id = member_id;
		this.role = role;
	}

	public long getActivity_user_id() {
		return activity_user_id;
	}

	public void setActivity_user_id(long activity_user_id) {
		this.activity_user_id = activity_user_id;
	}

	public long getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(long activity_id) {
		this.activity_id = activity_id;
	}

	public long getMeeting_id() {
		return meeting_id;
	}

	public void setMeeting_id(long meeting_id) {
		this.meeting_id = meeting_id;
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
	
	
}
