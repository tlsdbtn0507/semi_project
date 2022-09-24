package test.com.album;

public class AlbumVO {
	
	private long album_id;
	private long member_id;
	private String image_url;
	
	public AlbumVO() {
		// TODO Auto-generated constructor stub
	}

	public AlbumVO(long album_id, long member_id, String image_url) {
		super();
		this.album_id = album_id;
		this.member_id = member_id;
		this.image_url = image_url;
	}

	public long getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(long album_id) {
		this.album_id = album_id;
	}

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	
}
