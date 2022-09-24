package test.com.meeting;

public class MeetingVO {
	private long meeting_id;
	private String name; 
	private String explanation;
	private String gender;
	private String age;
	private String location;
	private boolean permission; // 가입 승낙 필요 
	private boolean secret; // 공개형 비공개형 
	
	public MeetingVO() {
		// TODO Auto-generated constructor stub
	}

	public MeetingVO(long meeting_id, String name, String explanation, String gender, String age, String location,
			boolean permission, boolean secret) {
		super();
		this.meeting_id = meeting_id;
		this.name = name;
		this.explanation = explanation;
		this.gender = gender;
		this.age = age;
		this.location = location;
		this.permission = permission;
		this.secret = secret;
	}

	public long getMeeting_id() {
		return meeting_id;
	}

	public void setMeeting_id(long meeting_id) {
		this.meeting_id = meeting_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isPermission() {
		return permission;
	}

	public void setPermission(boolean permission) {
		this.permission = permission;
	}

	public boolean isSecret() {
		return secret;
	}

	public void setSecret(boolean secret) {
		this.secret = secret;
	}
	
}
