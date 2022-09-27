package test.com.round;

import java.sql.Date;

public class RoundVO {
	private long round_id; // 라운드 번호
	private String name; // 라운드 이름
	private String round_date; // 라운딩 날짜
	private String course; // 코스
	private int total_people; // 인원 수
	private int current_people; // 인원 수
	private long member_id; // 멤버 번호
	
	
	// roundImage
	private String image_url;

	public RoundVO() {
		// TODO Auto-generated constructor stub
	}

	public RoundVO(long round_id, String name, String round_date, String course, int total_people, int current_people,
			String image_url,long member_id) {
		super();
		this.round_id = round_id;
		this.name = name;
		this.round_date = round_date;
		this.course = course;
		this.total_people = total_people;
		this.current_people = current_people;
		this.image_url = image_url;
		this.member_id = member_id;
	}

	public long getRound_id() {
		return round_id;
	}

	public void setRound_id(long round_id) {
		this.round_id = round_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRound_date() {
		return round_date;
	}

	public void setRound_date(String round_date) {
		this.round_date = round_date;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getTotal_people() {
		return total_people;
	}

	public void setTotal_people(int total_people) {
		this.total_people = total_people;
	}

	public int getCurrent_people() {
		return current_people;
	}

	public void setCurrent_people(int current_people) {
		this.current_people = current_people;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}


	
}
