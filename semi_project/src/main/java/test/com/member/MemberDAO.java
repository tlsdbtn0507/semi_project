package test.com.member;

import java.util.List;

public interface MemberDAO {
<<<<<<< HEAD
	// 회원가입하기
	public int insert(MemberVO vo);

	// 회원 수정
	public int update(MemberVO vo);

	// 회원 삭제
	public int delete(MemberVO vo);

	// 회원 목록
	public List<MemberVO> selectAll();

	// 아이디 확인
	public MemberVO idCheck(MemberVO vo);

	// 닉네임 확인
	public MemberVO nickNameCheck(MemberVO vo);

	// 로그인
	public MemberVO login(MemberVO vo);

=======
	// 회원가입하기   1
	public int insert(MemberVO vo);

	// 회원 수정     1
	public int update(MemberVO vo);

	// 회원 탈퇴       1
	public int delete(MemberVO vo);

	// 회원 목록      1 모임, 
	public List<MemberVO> selectAll();

	// 아이디 확인    1
	public MemberVO idCheck(MemberVO vo);

	// 닉네임 확인    1
	public MemberVO nickNameCheck(MemberVO vo);

	// 로그인        2
	public MemberVO login(MemberVO vo);
	
	//8
	
	// 47 시간(server) + 47 (jsp) = 94 + @(합치기)약 26시간 = 120시간  ///  하루 24 시간   120/24 = 5일이면 끝내야함.  5일  
>>>>>>> 0574ae638d7fa4a00e889ffeb0db092dac3d4166

}
