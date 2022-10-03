package test.com.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.notice.NoticeDAO;
import test.com.notice.NoticeDAOimpl;
import test.com.notice.NoticeVO;
import test.com.utils.DB_oracle;

public class MemberDAOimpl implements MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private NoticeDAO noticeDAO = new NoticeDAOimpl();

	public MemberDAOimpl() {
		try {
			Class.forName(MemberDB_postgres.DRIVER_NAME);
			System.out.println("Driver Successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void jdbcConnectionTest() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			String sql = "select version() as version";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("version"));
			}

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
	}

	@Override
	public int insert(MemberVO vo) {
		// 3-1
		System.out.println("insert()...");
		System.out.println(vo);
		// 3-2
		int flag = 0;
		// 3-3
		try {
			// 3-4 getConnection
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.MEMBER_ID); // 쿼리문이 들어감.
			rs = pstmt.executeQuery();
			rs.next();
			long member_id = rs.getLong("nextval");
			System.out.println(member_id);
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_INSERT);
			pstmt.setLong(1, member_id);
			pstmt.setString(2, vo.getNickname());
			pstmt.setString(3, vo.getMember_name());
			pstmt.setString(4, vo.getPassword());
			pstmt.setString(5, vo.getAge());
			pstmt.setString(6, vo.getHandy());
			pstmt.setString(7, vo.getLocation());
			pstmt.setString(8, vo.getGender());

			// 3-6
			flag = pstmt.executeUpdate();

			if (flag == 1) {
				// 알림
				NoticeVO noticeVO = new NoticeVO(vo.getNickname() + "님 가입을 축하합니다.", member_id, 0);
				noticeDAO.insert(noticeVO);
				System.out.println("가입알림 push 완료");
			}

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
	public int update(MemberVO vo) {
		System.out.println("update()...");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(DB_oracle.MEMBER_UPDATE);
			pstmt.setString(1, vo.getImage_url());
			pstmt.setString(2, vo.getNickname());
			pstmt.setString(3, vo.getLocation());
			pstmt.setString(4, vo.getHandy());
			pstmt.setLong(5, vo.getMember_id());

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
	public int delete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("selectAll()...");

		List<MemberVO> vos = new ArrayList<MemberVO>();

		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_MEMBER_SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMember_id(rs.getLong("member_id"));
				vo.setMember_name(rs.getString("member_name"));
				vo.setNickname(rs.getString("nickname"));
				vo.setAge(rs.getString("age"));
				vo.setHandy(rs.getString("handy"));
				vo.setLocation(rs.getString("location"));
				vo.setGender(rs.getString("gender"));
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
	public MemberVO idCheck(MemberVO vo) {
		System.out.println("idCheck()...");
		MemberVO vo2 = null;

		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_ID_CHECK);
			pstmt.setString(1, vo.getMember_name());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new MemberVO();
			}

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

		return vo2;
	}

	@Override
	public MemberVO nickNameCheck(MemberVO vo) {
		MemberVO vo2 = null;
		
		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_NICK_CHECK);
			pstmt.setString(1, vo.getNickname());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new MemberVO();
			}

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

		return vo2;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		MemberVO vo2 = new MemberVO();

		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_LOGIN);
			pstmt.setString(1, vo.getMember_name());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new MemberVO();
				vo2.setMember_id(rs.getLong("member_id"));
				vo2.setMember_name(rs.getString("member_name"));
				vo2.setPassword(rs.getString("password"));
				vo2.setNickname(rs.getString("nickname"));
				vo2.setAge(rs.getString("age"));
				vo2.setHandy(rs.getString("handy"));
				vo2.setLocation(rs.getString("location"));
				vo2.setGender(rs.getString("gender"));

			}

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

		return vo2;
	}

	@Override
	public MemberVO selectOne(String member_id) {
		System.out.println("selectOne()...");
		System.out.println("member_id:" + member_id);

		MemberVO vo = new MemberVO();

		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_MEMBER_SELECT_ONE);
			pstmt.setLong(1, Long.parseLong(member_id));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo.setMember_id(rs.getLong("member_id"));
				vo.setMember_name(rs.getString("member_name"));
				vo.setNickname(rs.getString("nickname"));
				vo.setAge(rs.getString("age"));
				vo.setHandy(rs.getString("handy"));
				vo.setLocation(rs.getString("location"));
				vo.setGender(rs.getString("gender"));
				vo.setImage_url(rs.getString("image_url"));
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
		return vo;
	}

}
