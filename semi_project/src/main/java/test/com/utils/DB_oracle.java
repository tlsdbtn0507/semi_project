package test.com.utils;

public interface DB_oracle {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "kosta";
	String PASSWORD = "hi123456";
	
	// 멤버 (회원) 
	String SQL_LOGIN = "select * from member where member_name=? and password=?";
	
	// 모임
	// member_id 컬럼은 일단 
	String MEETING_INSERT = "insert into "
			+ "meeting (meeting_id,name,explanation,gender,age,location,permission,secret,total_people,image_url,member_id) "
			+ "values(seq_meeting.nextval,?,?,?,?,?,?,?,?,?,?)";
	String MEETING_SEARCH_LIST_NAME = "select name from meeting where name like ?";
	String MEETING_SELECT_ALL = "select * from meeting";
	
	// 라운드  
	String ROUND_INSERT = "insert into "
			+ "round (round_id,name,course,total_people,round_date,image_url) "
			+ "values(seq_round.nextval,?,?,?,?,?)";
	String ROUND_SEARCH_LIST_NAME = "select name from round where name like ?";
	String ROUND_SELECT_ALL = "select * from round";
	String ROUND_SELECT_ONE = "select * from round where round_id = ?";
	
	//notice(알림)
		String SQL_SELECT_ALL = "select * from notice order by notice_id desc";
		String SQL_DELETE = "delete from notice order by notice_id desc";
		
		//main (메인페이지)
		String SQL_MY_MEETING_SELECT_ALL = "select meeting.meeting_id, name, explanation, image_url "
				+ "from meeting join meetinguser on meeting.meeting_id = meetinguser.meeting_id "
				+ "where meetinguser.member_id=?";
		String SQL_MY_ACTIVITY_SELECT_ALL = "select activity.activity_id,name,activity_date,activity_time,location, "
				+ "(select count(*)from activityuser where activityuser.activity_id = activity.activity_id) current_people, "
				+ "image_url, total_people from activity join activityUser "
				+ "on activity.activity_id = activityuser.activity_id "
				+ "where activityUser.member_id=?";
		String SQL_MY_ROUND_SELECT_ALL = "select round.round_id,name,course,round_date,(select count(*)from rounduser where rounduser.round_id = round.round_id) current_people, total_people, image_url from round join rounduser on round.round_id = rounduser.round_id where rounduser.member_id=?";

}