package test.com.event;

public class EventVO {
	private long event_id; // 이벤트 번호 
	private String title;  // 이벤트  제목 
	private String contents;  // 이벤트 내용 
	
	public EventVO() {
		// TODO Auto-generated constructor stub
	}

	public EventVO(long event_id, String title, String contents) {
		super();
		this.event_id = event_id;
		this.title = title;
		this.contents = contents;
	}

	public long getEvent_id() {
		return event_id;
	}

	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
}
