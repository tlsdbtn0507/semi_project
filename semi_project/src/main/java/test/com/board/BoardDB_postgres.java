package test.com.board;

public interface BoardDB_postgres {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "KOSTA";
	String PASSWORD = "hi123456";
	String SQL_CREATE_BOARD = "insert into board (board_id, date_for,meeting_id,title,contents, writer, notice)\r\n"
			+ "values(SEQ_board.nextval,sysdate,1,?,?,?,?)";
	
	String SQL_SHOW_ALL = "select * from board order by board_id desc";
	


}
