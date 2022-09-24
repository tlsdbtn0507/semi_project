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
		int flag = 0;

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER,
					DB_oracle.PASSWORD);
//			name,explanation,gender,age,location,permission,secret,total_people,image_url)
			pstmt = conn.prepareStatement(DB_oracle.MEETING_INSERT); // 쿼리문이 들어감.
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getExplanation());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getAge());
			pstmt.setString(5, vo.getLocation());
			pstmt.setString(6, vo.getPermission());
			pstmt.setString(7, vo.getSecret());
			pstmt.setInt(8, vo.getTotal_people());
			pstmt.setString(9, vo.getImage_url());
			pstmt.setLong(10, vo.getMember_id());

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // close가 있어서 finally 해줘야ㅕ 됨.
			if (rs != null) {
				try {
					rs.close(); // 나중에 쓴걸 먼저 닫는다.
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
		} // end finally

		return flag;
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
		System.out.println("selectAll()....");

		List<MeetingVO> vos = new ArrayList<MeetingVO>();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.MEETING_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MeetingVO vo = new MeetingVO();
				vo.setMeeting_id(rs.getLong("meeting_id"));
				vo.setName(rs.getString("name"));
				vo.setExplanation(rs.getString("explanation"));
				vo.setGender(rs.getString("gender"));
				vo.setAge(rs.getString("age"));
				vo.setLocation(rs.getString("location"));
				vo.setPermission(rs.getString("permission"));
				vo.setSecret(rs.getString("secret"));
				vo.setTotal_people(rs.getInt("total_people"));
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

	// 모임 검색 페이지
	@Override
	public List<MeetingVO> searchList(String searchKey, String searchWord) {
		List<MeetingVO> list = new ArrayList<MeetingVO>();
		searchKey = "meeting";
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);

			// 분기처리
			if (searchKey.equals("meeting")) {
				pstmt = conn.prepareStatement(DB_oracle.MEETING_SEARCH_LIST_NAME);
			}

			pstmt.setString(1, "%" + searchWord + "%"); // 여기에 물음표를 넣어주어야 하네.

			rs = pstmt.executeQuery();

			// rs.next() 읽어올 것이 있으면
			while (rs.next()) {
				MeetingVO vo = new MeetingVO();

				vo.setMeeting_id(rs.getLong("meeting_id"));
				vo.setName(rs.getString("name"));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // close가 있어서 finally 해줘야ㅕ 됨.
			if (rs != null) {
				try {
					rs.close(); // 나중에 쓴걸 먼저 닫는다.
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
		} // end finally
		return list;
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

	@Override
	public boolean invite(MeetingVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MeetingVO selectOne(MeetingVO vo) {
		MeetingVO vo2 = new MeetingVO();
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);

			pstmt = conn.prepareStatement(DB_oracle.MEETING_SELECT_ONE); // 쿼리문이 들어감.

			pstmt.setLong(1, vo.getMeeting_id());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2.setMeeting_id(rs.getLong("meeting_id"));
				vo2.setName(rs.getString("name"));
				vo2.setExplanation(rs.getString("explanation"));
				vo2.setTotal_people(rs.getInt("total_people"));
				vo2.setGender(rs.getString("gender"));
				vo2.setAge(rs.getString("age"));
				vo2.setLocation(rs.getString("location"));
				vo2.setImage_url(rs.getString("image_url"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // close가 있어서 finally 해줘야됨.
			if (rs != null) {
				try {
					rs.close(); // 나중에 쓴걸 먼저 닫는다.
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
		} // end finally

		return vo2;
	}

	@Override
	public int enter(MeetingUserVO vo) {
		int flag = 0;

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER,
					DB_oracle.PASSWORD);
			
			pstmt = conn.prepareStatement(DB_oracle.MEETING_ENTER); // 쿼리문이 들어감.
			
			pstmt.setLong(1, vo.getMeeting_id());
			pstmt.setLong(2, vo.getMember_id());
			pstmt.setString(3, vo.getRole());

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // close가 있어서 finally 해줘야ㅕ 됨.
			if (rs != null) {
				try {
					rs.close(); // 나중에 쓴걸 먼저 닫는다.
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
		} // end finally

		return flag;
	}
	
	

}
