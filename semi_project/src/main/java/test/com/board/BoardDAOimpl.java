package test.com.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;






public class BoardDAOimpl implements BoardDAO {

	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BoardDAOimpl() {
		System.out.println("BoardDAOimpl()..");
		// 1
		try {
			Class.forName(BoardDB_postgres.DRIVER_NAME);
			System.out.println("Driver successed..");

//			jdbcConnectionTest();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 2
		private void jdbcConnectionTest() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);
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
	public int createBoard(BoardVO vo) {
		System.out.println("insert()...");
				System.out.println(vo);
				// 1.
				int flag = 0;

				// 2.
				try {
					// 3.
					conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);
					//System.out.println("conn successed...");

					// 4.
					pstmt = conn.prepareStatement(BoardDB_postgres.SQL_CREATE_BOARD);
					// 5.
					pstmt.setString(1, vo.getTitle());
					pstmt.setString(2, vo.getContents());
					pstmt.setString(3, vo.getWriter());
					pstmt.setString(4, vo.getnotice());

					// 6.
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
	public BoardVO selectOne(BoardVO vo) {
		//System.out.println("selectOne()...");
		//System.out.println(vo);

		BoardVO vo2 = new BoardVO();

		// 2.
		try {
			// 3.
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);
			//System.out.println("conn successed...");
			// 4.
			pstmt = conn.prepareStatement(BoardDB_postgres.SQL_SELECT_ONE);
			pstmt.setLong(1, vo.getBoard_id());
			// 5
			rs = pstmt.executeQuery();

			// 6.
			while (rs.next()) {
				vo2.setBoard_id(rs.getLong("board_id"));
				vo2.setWdate(rs.getDate("date_for"));
				vo2.setMeeting_id(rs.getInt("meeting_id"));
				vo2.setTitle(rs.getString("title"));
				vo2.setContents(rs.getString("contents"));
				vo2.setWriter(rs.getString("writer"));
				vo2.setnotice(rs.getString("notice"));
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
	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<BoardVO> selectAll() {
		System.out.println("selectAll()...");

		// 1.
		List<BoardVO> vos = new ArrayList<BoardVO>();

		// 2.
		try {
			// 3.
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			// 4.
			pstmt = conn.prepareStatement(BoardDB_postgres.SQL_SHOW_ALL);

			// 5
			rs = pstmt.executeQuery();

			// 6.
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoard_id(rs.getLong("board_id"));
				vo.setWdate(rs.getDate("date_for"));
				vo.setMeeting_id(rs.getInt("meeting_id"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setWriter(rs.getString("writer"));
				vo.setnotice(rs.getString("notice"));
				vos.add(vo);
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

		return vos;
	}


}
