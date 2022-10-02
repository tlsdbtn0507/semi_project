package test.com.round;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.utils.DB_oracle;

public class RoundDAOimpl implements RoundDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	long round_id2 = 0l;

	public RoundDAOimpl() {
		try {
			Class.forName(DB_oracle.DRIVER_NAME);
			System.out.println("Driver Successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// round_id nextval
	// 라운드테이블과 라운드유저테이블에 사용할 것이다.
	public long round_id() {
		long round_id = 0l;
		RoundVO vo2 = new RoundVO();
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);

			pstmt = conn.prepareStatement(DB_oracle.ROUND_ID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2.setRound_id(rs.getLong("nextval"));
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

		round_id = vo2.getRound_id();

		return round_id;
	}

	// 라운드 개설하기 (현재 본인이 라운드 장이 된다.)
	@Override
	public int insert(RoundVO vo) {
		int flag = 0;

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);

			pstmt = conn.prepareStatement(DB_oracle.ROUND_INSERT); // 쿼리문이 들어감.

			pstmt.setLong(1, vo.getRound_id());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getCourse());
			pstmt.setInt(4, vo.getTotal_people());
			pstmt.setString(5, vo.getRound_date().toString());
			pstmt.setString(6, vo.getImage_url());
			pstmt.setLong(7, vo.getMember_id());

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
	public int update(RoundVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RoundVO> selectAll() {
		List<RoundVO> vos = new ArrayList<RoundVO>();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.ROUND_SELECT_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RoundVO vo = new RoundVO();
				vo.setRound_id(rs.getLong("round_id"));
				vo.setName(rs.getString("name"));
				vo.setCourse(rs.getString("course"));
				vo.setTotal_people(rs.getInt("total_people"));
				vo.setRound_date(rs.getString("round_date"));
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
	public List<RoundVO> searchList(String searchWord) {
		List<RoundVO> list = new ArrayList<RoundVO>();
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);

			pstmt = conn.prepareStatement(DB_oracle.ROUND_SEARCH_LIST_NAME); // TEL 이 넘어오면

			pstmt.setString(1, "%" + searchWord + "%"); // 여기에 물음표를 넣어주어야 하네.

			rs = pstmt.executeQuery();

			// rs.next() 읽어올 것이 있으면
			while (rs.next()) {
				RoundVO vo = new RoundVO();

				vo.setRound_id(rs.getLong("round_id"));
				vo.setName(rs.getString("name"));
				vo.setCourse(rs.getString("course"));
				vo.setTotal_people(rs.getInt("total_people"));
				vo.setCurrent_people(rs.getInt("current_people"));
				vo.setRound_date(rs.getString("round_date"));
				vo.setImage_url(rs.getString("image_url"));

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
		System.out.println(list);
		System.out.println("서치확인");
		return list;
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
				vo.setRound_date(rs.getString("round_date"));
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

	// 현재 클릭한 round의 round_id 와 현재 로그인한 사람이 round_user 에 있는지 판별하는 메서드
	public boolean distinguish(long round_id, long member_id) {

		boolean b = false;

		RoundUserVO vo = new RoundUserVO();
		vo.setRound_id(round_id);
		vo.setMember_id(member_id);

		int count_role = 0;
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);

			pstmt = conn.prepareStatement(DB_oracle.ROUND_DISTINGUISH); // 쿼리문이 들어감.

			pstmt.setLong(1, vo.getRound_id());
			pstmt.setLong(2, vo.getMember_id());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				count_role = rs.getInt("count(role)");

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
		}

		// 한명이 있다고 나오면 true로 출력.
		if (count_role == 1) {
			b = true;
		}

		return b;
	}

	@Override
	public RoundVO selectOne(RoundUserVO vo1) {
		RoundVO vo2 = new RoundVO();
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);

			// 라운드에 가입 되어 있지 않다면
			// 이름이랑 코스만 일단 띄우게 함.

			if (!distinguish(vo1.getRound_id(), vo1.getMember_id())) {
				pstmt = conn.prepareStatement(DB_oracle.ROUND_SELECT_ONE); // 쿼리문이 들어감.

				pstmt.setLong(1, vo1.getRound_id());

				rs = pstmt.executeQuery();

				while (rs.next()) {
					vo2.setRound_id(rs.getLong("round_id"));
					vo2.setName(rs.getString("name"));
					vo2.setCourse(rs.getString("course"));

//					vo2.setTotal_people(rs.getInt("total_people"));
//					vo2.setRound_date(rs.getString("round_date"));
//					vo2.setImage_url(rs.getString("image_url"));
				}
			}
			// 라운드에 가입이 되어있다면 다 띄움.
			else if (distinguish(vo1.getRound_id(), vo1.getMember_id())) {
				pstmt = conn.prepareStatement(DB_oracle.ROUND_SELECT_ONE); // 쿼리문이 들어감.

				pstmt.setLong(1, vo1.getRound_id());

				rs = pstmt.executeQuery();

				while (rs.next()) {
					vo2.setRound_id(rs.getLong("round_id"));
					vo2.setName(rs.getString("name"));
					vo2.setCourse(rs.getString("course"));
					vo2.setTotal_people(rs.getInt("total_people"));
					vo2.setRound_date(rs.getString("round_date"));
					vo2.setImage_url(rs.getString("image_url"));
				}
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
	public int enter(RoundUserVO vo) {

		int flag = 0;

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);

			pstmt = conn.prepareStatement(DB_oracle.ROUND_ENTER); // 쿼리문이 들어감.

			pstmt.setLong(1, vo.getRound_id());
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
