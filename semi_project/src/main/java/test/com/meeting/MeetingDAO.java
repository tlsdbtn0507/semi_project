package test.com.meeting;

import java.util.List;

import test.com.member.MemberVO;

public interface MeetingDAO {

	// 모임 개설하기 1
	public int insert(MeetingVO vo);

	// 모임 수정하기 1
	public int update(MeetingVO vo);

	// 모임 탈퇴하기 2
	public int leave(MemberVO vo);

	// 모임 리스트 1
	public List<MeetingVO> selectAll();

	// 모임 검색하기 1 (진행중)
	public List<MeetingVO> searchList(String key, String value);

	// 모임 멤버 초대하기 4
	public boolean invite(MeetingVO vo);

	// 나의 모임리스트 조회하기
	public List<MeetingVO> mySelectAll(String member_id);
	// 10
}
