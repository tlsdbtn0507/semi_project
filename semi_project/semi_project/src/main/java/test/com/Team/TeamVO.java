package test.com.Team;

public class TeamVO {
	private long team_id;
	private String name;  //조 명 
	private String members; // 유저 이름들 
	
	public TeamVO() {
		// TODO Auto-generated constructor stub
	}
	public TeamVO(long team_id, String name, String members) {
		super();
		this.team_id = team_id;
		this.name = name;
		this.members = members;
	}
	public long getTeam_id() {
		return team_id;
	}
	public void setTeam_id(long team_id) {
		this.team_id = team_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	
	
}
