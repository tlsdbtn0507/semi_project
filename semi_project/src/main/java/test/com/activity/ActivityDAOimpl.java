package test.com.activity;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import test.com.meeting.MeetingVO;
import test.com.utils.DB_oracle;

public class ActivityDAOimpl implements ActivityDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ActivityDAOimpl() {
		try {
			Class.forName(DB_oracle.DRIVER_NAME);
			System.out.println("Driver Successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// 액티비티 테이블과 액티비티 유저 테이블에 사용할 것이다.
	public long activity_id() {

		long activity_id = 0l;
		ActivityVO vo2 = new ActivityVO();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);

			pstmt = conn.prepareStatement(DB_oracle.ACTIVITY_ID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2.setActivity_id(rs.getLong("nextval"));
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

		activity_id = vo2.getActivity_id();

		return activity_id;
	}

	@Override
	public int insert(ActivityVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(DB_oracle.ACTIVITY_INSERT); // 쿼리문이 들어감.

			pstmt.setLong(1, vo.getActivity_id());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getExplanation());
			pstmt.setString(4, vo.getActivity_date());
			pstmt.setString(5, vo.getActivity_time());
			pstmt.setString(6, vo.getLocation());
			pstmt.setInt(7, vo.getTotal_people());
			pstmt.setLong(8, vo.getMember_id());
			pstmt.setLong(9, vo.getMeeting_id());
			pstmt.setString(10, vo.getImage_url());

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
	public int enter(ActivityUserVO vo) {
		int flag = 0;

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);

			pstmt = conn.prepareStatement(DB_oracle.ACTIVITY_ENTER); // 쿼리문이 들어감.

			pstmt.setLong(1, vo.getActivity_id());
			pstmt.setLong(2, vo.getMeeting_id());
			pstmt.setLong(3, vo.getMember_id());
			pstmt.setString(4, vo.getRole());

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
		} // end finally

		return flag;
	}

	@Override
	public int update(ActivityVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ActivityVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ActivityVO> selectAll() {
		System.out.println("selectAll()...");

		List<ActivityVO> vos = new ArrayList<ActivityVO>();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("Conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_ACTIVITY_SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ActivityVO vo = new ActivityVO();
				vo.setActivity_id(rs.getLong("activity_id"));
				vo.setName(rs.getString("name"));
				vo.setActivity_date(rs.getString("activity_date"));
				vo.setActivity_time(rs.getString("activity_time"));
				vo.setLocation(rs.getString("location"));
				vo.setCurrent_people(rs.getInt("current_people"));
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

	@Override
	public List<ActivityVO> searchList(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivityVO> mySelectAll(String member_id, String activityState) {
		System.out.println("mySelectAll()...");

		List<ActivityVO> vos = new ArrayList<ActivityVO>();
		Date today = null;
		Date activity_date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String current = dateFormat.format(System.currentTimeMillis());

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("Conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_MY_ACTIVITY_SELECT_ALL);
			pstmt.setLong(1, Long.parseLong(member_id));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				try {
					activity_date = dateFormat.parse(rs.getString("activity_date"));
					today = dateFormat.parse(current);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				int compare = today.compareTo(activity_date);

				System.out.println("today: " + today);
				System.out.println("activity_date:" + activity_date);
				System.out.println(compare);
				if (activityState.equals("활동중") & compare == 0) {
					ActivityVO vo = new ActivityVO();
					vo.setActivity_id(rs.getLong("activity_id"));
					vo.setName(rs.getString("name"));
					vo.setActivity_date(rs.getString("activity_date"));
					vo.setActivity_time(rs.getString("activity_time"));
					vo.setLocation(rs.getString("location"));
					vo.setCurrent_people(rs.getInt("current_people"));
					vo.setTotal_people(rs.getInt("total_people"));
					vo.setImage_url(rs.getString("image_url"));
					vos.add(vo);
				} else if (activityState.equals("활동전") & compare < 0) {
					ActivityVO vo = new ActivityVO();
					vo.setActivity_id(rs.getLong("activity_id"));
					vo.setName(rs.getString("name"));
					vo.setActivity_date(rs.getString("activity_date"));
					vo.setActivity_time(rs.getString("activity_time"));
					vo.setLocation(rs.getString("location"));
					vo.setCurrent_people(rs.getInt("current_people"));
					vo.setTotal_people(rs.getInt("total_people"));
					vo.setImage_url(rs.getString("image_url"));
					vos.add(vo);
				} else if (activityState.equals("활동후") & compare > 0) {
					ActivityVO vo = new ActivityVO();
					vo.setActivity_id(rs.getLong("activity_id"));
					vo.setName(rs.getString("name"));
					vo.setActivity_date(rs.getString("activity_date"));
					vo.setActivity_time(rs.getString("activity_time"));
					vo.setLocation(rs.getString("location"));
					vo.setCurrent_people(rs.getInt("current_people"));
					vo.setTotal_people(rs.getInt("total_people"));
					vo.setImage_url(rs.getString("image_url"));
					vos.add(vo);
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
		return vos;
	}

	@Override
	public List<ActivityVO> recommendSelectAll(String member_id, String category) {
		System.out.println("recommendSelectAll()..." + category);
		List<ActivityVO> vos = new ArrayList<ActivityVO>();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("Conn Successed...");
			// category(또래끼리,성별끼리,실력이 비슷한,내 근처의 )
			if (category.equals("또래끼리")) {
				pstmt = conn.prepareStatement(DB_oracle.SQL_RECOMMEND_ACTIVITY_AGE_SELECT_ALL);
			} else if (category.equals("성별끼리")) {
				pstmt = conn.prepareStatement(DB_oracle.SQL_RECOMMEND_ACTIVITY_GENDER_SELECT_ALL);
			} else if (category.equals("실력이 비슷한")) {
				pstmt = conn.prepareStatement(DB_oracle.SQL_RECOMMEND_ACTIVITY_HANDY_SELECT_ALL);
			} else if (category.equals("내 근처의")) {
				pstmt = conn.prepareStatement(DB_oracle.SQL_RECOMMEND_ACTIVITY_LOCATION_SELECT_ALL);
			}
			System.out.println(category);
			pstmt.setLong(1, Long.parseLong(member_id));
			pstmt.setLong(2, Long.parseLong(member_id));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ActivityVO vo = new ActivityVO();
				vo.setActivity_id(rs.getLong("activity_id"));
				vo.setName(rs.getString("name"));
				vo.setActivity_date(rs.getString("activity_date"));
				vo.setActivity_time(rs.getString("activity_time"));
				vo.setLocation(rs.getString("activity_location"));
				vo.setCurrent_people(rs.getInt("current_people"));
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

	@Override
	public List<ActivityVO> imminentSelectAll(String member_id) {
		System.out.println("imminentSelectAll()...");

		List<ActivityVO> vos = new ArrayList<ActivityVO>();
		int d_day = 0;

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("Conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_IMMINENT_ACTIVITY_SELECT_ALL);
			pstmt.setLong(1, Long.parseLong(member_id));
			rs = pstmt.executeQuery();
			while (rs.next()) {

				d_day = rs.getInt("d_day");
				System.out.println("d_day: " + d_day);
				if (0 < d_day & d_day < 4) {
					ActivityVO vo = new ActivityVO();
					vo.setActivity_id(rs.getLong("activity_id"));
					vo.setName(rs.getString("name"));
					vo.setActivity_date(rs.getString("activity_date"));
					vo.setActivity_time(rs.getString("activity_time"));
					vo.setLocation(rs.getString("activity_location"));
					vo.setCurrent_people(rs.getInt("current_people"));
					vo.setTotal_people(rs.getInt("total_people"));
					vo.setImage_url(rs.getString("image_url"));
					vos.add(vo);
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
		return vos;
	}

	// 모임내 액티비티 리스트
	@Override
	public List<ActivityVO> inSelectAll(MeetingVO vo2) {
		List<ActivityVO> vos = new ArrayList<ActivityVO>();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("Conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.MEETING_ACTIVITY_SELECT_ALL);

			pstmt.setLong(1, vo2.getMeeting_id());

			System.out.println(vo2.getMeeting_id());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ActivityVO vo = new ActivityVO();
				vo.setActivity_id(rs.getLong("activity_id"));
				vo.setName(rs.getString("name"));
				vo.setExplanation(rs.getString("explanation"));
				vo.setActivity_date(rs.getString("activity_date"));
				vo.setActivity_time(rs.getString("activity_time"));
				vo.setLocation(rs.getString("location"));
				vo.setCurrent_people(rs.getInt("current_people"));
				vo.setTotal_people(rs.getInt("total_people"));
				vo.setImage_url(rs.getString("image_url"));
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

}
