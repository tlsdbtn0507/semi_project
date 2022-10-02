package test.com.notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.member.MemberDB_postgres;
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
		System.out.println("insert()...");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, MemberDB_postgres.USER, MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_NOTICE_INSERT);
			pstmt.setString(1, vo.getContents());
			pstmt.setLong(2, vo.getMember_id());
			pstmt.setLong(3, vo.getMeeting_id());

			// 3-6
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		} // end finally
		return flag;
	}

	@Override
	public List<NoticeVO> selectAll(String Member_id) {
		System.out.println("selectAll()...");

		List<NoticeVO> vos = new ArrayList<NoticeVO>();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, MemberDB_postgres.USER, MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_NOTICE_SELECT_ALL);
			pstmt.setLong(1, Long.parseLong(Member_id));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setNotice_id(rs.getLong("notice_id"));
				vo.setMember_id(rs.getLong("member_id"));
				vo.setContents(rs.getString("contents"));
				vo.setMeeting_id(rs.getLong("meeting_id"));
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
	public int delete(long notice_id) {
		System.out.println("delete()...");
		System.out.println(notice_id);
		int flag = 0;

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, MemberDB_postgres.USER, MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_NOTICE_DELETE);
			pstmt.setLong(1, notice_id);
			flag = pstmt.executeUpdate();

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
		} // end finally

		return flag;
	}

	@Override
	public int activity_notice(long member_id) {
		System.out.println("activity_notice()...");
		NoticeVO vo = new NoticeVO();
		NoticeDAO noticeDAO = new NoticeDAOimpl();
		
		int flag = 0;
		int d_day = 0;
		long activityUser = 0;

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("Conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_ACTIVITY_NOTICE);
			pstmt.setLong(1, member_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				d_day = rs.getInt("d_day");
				System.out.println("d_day: " + d_day);
				if (d_day == 0 & rs.getString("notice_start").equals("false")) {
					
					vo.setContents("\'"+rs.getString("name")+"\'"+" 액티비티가 시작되었습니다.");
					vo.setMeeting_id(rs.getLong("meeting_id"));
					vo.setMember_id(rs.getLong("member_id"));
					activityUser = rs.getLong("activity_user");
					
					noticeDAO.insert(vo);
					pstmt = conn.prepareStatement(DB_oracle.SQL_ACTIVITY_UPDATE_NOTICE_START);
					pstmt.setLong(1, activityUser);
				} else if (d_day >0 & rs.getString("notice_end").equals("false")) {
					vo.setContents("\'"+rs.getString("name")+"\'"+" 액티비티가 종료되었습니다.");
					vo.setMeeting_id(rs.getLong("meeting_id"));
					vo.setMember_id(rs.getLong("member_id"));
					activityUser = rs.getLong("activity_user");
					
					noticeDAO.insert(vo);
					pstmt = conn.prepareStatement(DB_oracle.SQL_ACTIVITY_UPDATE_NOTICE_END);
					pstmt.setLong(1, activityUser);
				}
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
		return flag;
	}

}
