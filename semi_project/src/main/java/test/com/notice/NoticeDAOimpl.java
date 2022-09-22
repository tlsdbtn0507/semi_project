package test.com.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import test.com.utils.DB_oracle;

public class NoticeDAOimpl implements NoticeDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public NoticeDAOimpl() {
		try {
			Class.forName(DB_oracle.DRIVER_NAME);
			System.out.println("Driver Successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	@Override
	public int insert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<NoticeVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
