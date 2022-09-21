package test.com.user;

public class UserVO {
	private long user_id; // 사용자 번호  
	private String username; // 사용자 아이디  
	private String password; // 비밀번호   
	private String nickname; // 사용자 닉네임   
	private String age; // 나이  
	private String gender; // 성별
	private String location; // 장소 
	private String handy; // 타수 
	private Enum role; // 역할 
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserVO(long user_id, String username, String password, String nickname, String age, String gender,
			String location, String handy, Enum role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.handy = handy;
		this.role = role;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	
}
