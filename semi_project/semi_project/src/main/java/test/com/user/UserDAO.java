package test.com.user;

import java.util.List;

public interface UserDAO {
	// 회원가입하기
	public int insert(UserVO vo);

	// 회원 수정
	public int update(UserVO vo);

	// 회원 삭제
	public int delete(UserVO vo);

	// 회원 목록
	public List<UserVO> selectAll();

	// 아이디 확인
	public UserVO idCheck(UserVO vo);

	// 닉네임 확인
	public UserVO nickNameCheck(UserVO vo);

	// 로그인
	public UserVO login(UserVO vo);

}
