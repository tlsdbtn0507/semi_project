package test.com.round;

public class RoundUserVO {
	long round_user_id;
	long member_id;
	String role;
	// fk
	long round_id;
	
	public RoundUserVO() {
		// TODO Auto-generated constructor stub
	}

	public RoundUserVO(long round_user_id, long member_id, String role, long round_id) {
		super();
		this.round_user_id = round_user_id;
		this.member_id = member_id;
		this.role = role;
		this.round_id = round_id;
	}

	public long getRound_user_id() {
		return round_user_id;
	}

	public void setRound_user_id(long round_user_id) {
		this.round_user_id = round_user_id;
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

	public long getRound_id() {
		return round_id;
	}

	public void setRound_id(long round_id) {
		this.round_id = round_id;
	}
	
	
}
