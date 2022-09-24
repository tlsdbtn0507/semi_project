package test.com.utils;

public enum Role {
	LEADER("ROLE_LEADER"), // 리더 
	MASTER("ROLE_MASTER"), // 운영자 
	MEMBER("ROLE_MEMBER"); // 멤버  
	
	private String value;

	Role(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	
	
}
