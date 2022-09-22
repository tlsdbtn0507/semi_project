package test.com.meeting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.member.MemberVO;
import test.com.utils.DB_oracle;

public class MeetingDAOimpl implements MeetingDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public MeetingDAOimpl() {
		try {
			Class.forName(DB_oracle.DRIVER_NAME);
			System.out.println("Driver Successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int insert(MeetingVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MeetingVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int leave(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MeetingVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MeetingVO> searchList(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean invite(MeetingVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MeetingVO> mySelectAll(String member_id) {
		System.out.println("mySelectAll()...");
		List<MeetingVO> vos = new ArrayList<MeetingVO>();
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("Conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_MY_MEETING_SELECT_ALL);
			pstmt.setLong(1, Long.parseLong(member_id));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MeetingVO vo = new MeetingVO();
				vo.setMeeting_id(rs.getLong("meeting_id"));
				vo.setName(rs.getString("name"));
				vo.setExplanation(rs.getString("explanation"));
				vo.setImage_url(rs.getString("image_url"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return vos;
	}

}
