package test.com.member;

import java.util.List;

public interface MemberDAO {
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

	public MemberVO selectOne(String member_id);


}
