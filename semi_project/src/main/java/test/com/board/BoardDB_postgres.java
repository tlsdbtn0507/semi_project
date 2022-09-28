package test.com.board;

public interface BoardDB_postgres {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "KOSTA";
	String PASSWORD = "hi123456";
	String SQL_CREATE_BOARD = "insert into board (board_id, date_for,meeting_id,title,contents, writer, notice)"
			+ "values(SEQ_board.nextval,sysdate,1,?,?,?,?)";
	
	String SQL_SHOW_ALL = "select * from board order by board_id desc";
	String SQL_SELECT_ONE = "select * from board where board_id=?";
	String SQL_DELETE = "delete from board where board_id=?";
	String SQL_UPDATE = "update board set date_for=sysdate, title=?,contents=?, writer=?, notice=? where board_id=?";
	String SQL_MEETING_NAME = "select name from meeting where meeting_id = ?";
	


}
