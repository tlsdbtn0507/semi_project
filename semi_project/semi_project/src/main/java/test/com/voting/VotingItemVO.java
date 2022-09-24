package test.com.voting;


public class VotingItemVO {
	private long item_id; // 항목 번호 
	private String item;  // 항목 
	
	public VotingItemVO() {
		// TODO Auto-generated constructor stub
	}

	public VotingItemVO(long item_id, String item) {
		super();
		this.item_id = item_id;
		this.item = item;
	}

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	
	
}
