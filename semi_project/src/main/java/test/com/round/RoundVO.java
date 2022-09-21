package test.com.round;

import java.sql.Date;

public class RoundVO {
	private long round_id; // 라운드 번호 
	private String name;  // 라운드 이름 
	private Date round_date; // 라운딩 날짜 
	private String course; // 코스 
	private int personnel; // 인원 수  
	
	public RoundVO() {
		// TODO Auto-generated constructor stub
	}

	public RoundVO(long round_id, String name, Date round_date, String course, int personnel) {
		super();
		this.round_id = round_id;
		this.name = name;
		this.round_date = round_date;
		this.course = course;
		this.personnel = personnel;
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

	public Date getRound_date() {
		return round_date;
	}

	public void setRound_date(Date round_date) {
		this.round_date = round_date;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getPersonnel() {
		return personnel;
	}

	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}
	
}
