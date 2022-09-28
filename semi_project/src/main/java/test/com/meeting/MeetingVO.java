package test.com.meeting;

public class MeetingVO {
	private long meeting_id;
	private String name;
	private String explanation;
	private String gender;
	private String age;
	private String location;
	private String permission; // 가입 승낙 필요
	private String secret; // 공개형 비공개형
	private String handy; // 타수 
	private int total_people; // 컬럼에는 없고 VO에만 있음.
	private String creation_date; // 타수 
	
	// fk
	private long member_id;

	// meetingImage
	private String image_url;

	public MeetingVO() {
		// TODO Auto-generated constructor stub
	}

	public MeetingVO(long meeting_id, String name, String explanation, String gender, String age, String location,
			String permission, String secret, String handy,String image_url, int total_people,long member_id,String creation_date) {
		super();
		this.meeting_id = meeting_id;
		this.name = name;
		this.explanation = explanation;
		this.gender = gender;
		this.age = age;
		this.location = location;
		this.permission = permission;
		this.secret = secret;
		this.image_url = image_url;
		this.total_people = total_people;
		this.member_id = member_id;
		this.handy = handy;
		this.creation_date = creation_date;
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

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public int getTotal_people() {
		return total_people;
	}

	public void setTotal_people(int total_people) {
		this.total_people = total_people;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getHandy() {
		return handy;
	}

	public void setHandy(String handy) {
		this.handy = handy;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

}
