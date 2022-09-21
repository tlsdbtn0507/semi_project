package test.com.user;

import java.util.List;

public interface UserDAO {
	// 회원가입하기   1
	public int insert(UserVO vo);

	// 회원 수정     1
	public int update(UserVO vo);

	// 회원 탈퇴       1
	public int delete(UserVO vo);

	// 회원 목록      1 모임, 
	public List<UserVO> selectAll();

	// 아이디 확인    1
	public UserVO idCheck(UserVO vo);

	// 닉네임 확인    1
	public UserVO nickNameCheck(UserVO vo);

	// 로그인        2
	public UserVO login(UserVO vo);
	
	//8
	
	// 47 시간(server) + 47 (jsp) = 94 + @(합치기)약 26시간 = 120시간  ///  하루 24 시간   120/24 = 5일이면 끝내야함.  5일  

}
