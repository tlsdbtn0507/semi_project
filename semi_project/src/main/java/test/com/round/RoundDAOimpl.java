package test.com.round;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.meeting.MeetingVO;
import test.com.utils.DB_oracle;

public class RoundDAOimpl implements RoundDAO {
	

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public RoundDAOimpl() {
		try {
			Class.forName(DB_oracle.DRIVER_NAME);
			System.out.println("Driver Successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int insert(RoundVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(RoundVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RoundVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoundVO> searchList(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoundVO> mySelectAll(String member_id) {
		System.out.println("mySelectAll()...");
		List<RoundVO> vos = new ArrayList<RoundVO>();
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("Conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_MY_ROUND_SELECT_ALL);
			pstmt.setLong(1, Long.parseLong(member_id));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RoundVO vo = new RoundVO();
				vo.setRound_id(rs.getLong("round_id"));
				vo.setName(rs.getString("name"));
				vo.setRound_date(rs.getDate("round_date"));
				vo.setCourse(rs.getString("course"));
				vo.setTotal_people(rs.getInt("total_people"));
				vo.setCurrent_people(rs.getInt("current_people"));
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
