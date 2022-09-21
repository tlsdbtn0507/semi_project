package test.com.board;

public class BoardVO {
	private long board_id; 
	private String title; 
	private String contents; 
	private boolean notice; 
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(long board_id, String title, String contents, boolean notice) {
		super();
		this.board_id = board_id;
		this.title = title;
		this.contents = contents;
		this.notice = notice;
	}

	public long getBoard_id() {
		return board_id;
	}

	public void setBoard_id(long board_id) {
		this.board_id = board_id;
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

	public boolean isNotice() {
		return notice;
	}

	public void setNotice(boolean notice) {
		this.notice = notice;
	}
	
	
}
