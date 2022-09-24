package test.com.board;

public class BoardImageVO {
	private long image_id;
	private String image_url;
	
	public BoardImageVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardImageVO(long image_id, String image_url) {
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
