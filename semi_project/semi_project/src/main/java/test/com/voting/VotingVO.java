package test.com.voting;

import java.sql.Date;

public class VotingVO {
	private long voting_id;
	private String title;  // 투표 제목 
	private Date end_period; // 유저 이름들 
	
	public VotingVO() {
		// TODO Auto-generated constructor stub
	}

	public VotingVO(long voting_id, String title, Date end_period) {
		super();
		this.voting_id = voting_id;
		this.title = title;
		this.end_period = end_period;
	}

	public long getVoting_id() {
		return voting_id;
	}

	public void setVoting_id(long voting_id) {
		this.voting_id = voting_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getEnd_period() {
		return end_period;
	}

	public void setEnd_period(Date end_period) {
		this.end_period = end_period;
	}
	
}
