package test.com.activity;

public class ActivityVO {
	private long activity_id;
	private String name;  //액티비티명 
	private String explanation; // 액티비티 설명
	private String start_period; // 시작 날짜 
	private String end_period; // 마감 날짜 
	private String location; // 장소 
	private int personnel; // 인원 수 
	
	public ActivityVO() {
		// TODO Auto-generated constructor stub
	}

	public ActivityVO(long activity_id, String name, String explanation, String start_period, String end_period,
			String location, int personnel) {
		super();
		this.activity_id = activity_id;
		this.name = name;
		this.explanation = explanation;
		this.start_period = start_period;
		this.end_period = end_period;
		this.location = location;
		this.personnel = personnel;
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

	public String getStart_period() {
		return start_period;
	}

	public void setStart_period(String start_period) {
		this.start_period = start_period;
	}

	public String getEnd_period() {
		return end_period;
	}

	public void setEnd_period(String end_period) {
		this.end_period = end_period;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPersonnel() {
		return personnel;
	}

	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}
	
	
}
