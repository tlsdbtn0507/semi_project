package test.com.activity;

public class ActivityVO {
	private long activity_id;
	private String name;  //액티비티명 
	private String explanation; // 액티비티 설명
	private String activity_date; // 액티비티 날짜
	private String activity_time; // 액티비티 시간
	private String location; // 장소 
	private int total_people; // 총 인원 수  
	private int current_people; // 현재 인원 수  
	private long meeting_id;
	private long member_id;
	
	//activity image
	private String image_url;
	
	public ActivityVO() {
		// TODO Auto-generated constructor stub
	}

	public ActivityVO(long activity_id, String name, String explanation, String activity_date, String activity_time,
			String location, int total_people, int current_people, String image_url,long meeting_id, long member_id) {
		super();
		this.activity_id = activity_id;
		this.name = name;
		this.explanation = explanation;
		this.activity_date = activity_date;
		this.activity_time = activity_time;
		this.location = location;
		this.total_people = total_people;
		this.current_people = current_people;
		this.image_url = image_url;
		this.meeting_id = meeting_id;
		this.member_id = member_id;
	}

	public long getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(long activity_id) {
		this.activity_id = activity_id;
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

	public String getActivity_date() {
		return activity_date;
	}

	public void setActivity_date(String activity_date) {
		this.activity_date = activity_date;
	}

	public String getActivity_time() {
		return activity_time;
	}

	public void setActivity_time(String activity_time) {
		this.activity_time = activity_time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	

	
}
