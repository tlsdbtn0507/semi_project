package test.com.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import test.com.utils.DB_oracle;

public class MemberDAOimpl implements MemberDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDAOimpl() {
		try {
			Class.forName(DB_oracle.DRIVER_NAME);
			System.out.println("Driver Successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO idCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO nickNameCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		MemberVO vo2 = new MemberVO();
	      
	      try {
	         conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
	         System.out.println("conn successed...");
	         pstmt = conn.prepareStatement(DB_oracle.SQL_LOGIN);
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
	            vo2.setGender(rs.getString("gender"));
	            vo2.setLocation(rs.getString("location"));
	            vo2.setHandy(rs.getString("handy"));
//	            vo2.setRole(rs.get("role"));
	            
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
	

}


