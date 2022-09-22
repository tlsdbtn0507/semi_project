package test.com.utils;

public interface DB_oracle {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "kosta";
	String PASSWORD = "hi123456";
	
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
	
	//meeting(모임)
	
}
