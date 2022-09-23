package test.com.member;

public class MemberVO {
	private long member_id; // 사용자 번호
	private String member_name; // 사용자 아이디
	private String password; // 비밀번호
	private String nickname; // 사용자 닉네임
	private String age; // 나이
	private String gender; // 성별
	private String location; // 장소
	private String handy; // 타수
	private Enum role; // 역할

	// memberImage
	private String image_url;

	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public MemberVO(long member_id, String member_name, String password, String nickname, String age, String gender,
			String location, String handy, Enum role, String image_url) {
		super();
		this.member_id = member_id;
		this.member_name = member_name;
		this.password = password;
		this.nickname = nickname;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.handy = handy;
		this.role = role;
		this.image_url = image_url;
	}

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHandy() {
		return handy;
	}

	public void setHandy(String handy) {
		this.handy = handy;
	}

	public Enum getRole() {
		return role;
	}

	public void setRole(Enum role) {
		this.role = role;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	
	
}

