package test.com.meeting;

import java.util.List;

import test.com.user.UserVO;

public interface MeetingDAO {
	
	// 모임 개설하기
	public int insert(MeetingVO vo);
	// 모임 수정하기
	public int update(MeetingVO vo);
	// 모임 탈퇴하기 
	public int leave(UserVO vo);
	// 모임 리스트
	public List<MeetingVO> selectAll();
	// 모임 검색하기
	public List<MeetingVO> searchList(String key, String value);
	// 모임 멤버 초대하기
	public boolean invite(MeetingVO vo);
}
