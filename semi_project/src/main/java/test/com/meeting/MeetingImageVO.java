package test.com.meeting;

public class MeetingImageVO {
	private long image_id;
	private String image_url;
	
	public MeetingImageVO() {
		// TODO Auto-generated constructor stub
	}

	public MeetingImageVO(long image_id, String image_url) {
		super();
		this.image_id = image_id;
		this.image_url = image_url;
	}

	public long getImage_id() {
		return image_id;
	}

	public void setImage_id(long image_id) {
		this.image_id = image_id;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	
}