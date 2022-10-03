package test.com.activity;

import java.util.List;

import test.com.meeting.MeetingVO;

public interface ActivityDAO {

	// 액티비티 개설하기    1
	public int insert(ActivityVO vo); 
	
	// 액티비티 입장하기 
	public int enter(ActivityUserVO vo);

	// 액티비티 수정하기     1
	public int update(ActivityVO vo);

	// 액티비티 삭제하기     1  
	public int delete(ActivityVO vo);

	// 액티비티 전체 리스트      1
	public List<ActivityVO> selectAll();
	
	// 내 액티비티 전체 리스트
	public List<ActivityVO> mySelectAll(String member_name, String activityState);
	
	// 모임 내 액티비티 리스트
	public List<ActivityVO> inSelectAll(String member_id, String activityState);

	// 액티비티 검색하기     1
	public List<ActivityVO> searchList(String key, String value);

	//액티비티 추천 리스트
	public List<ActivityVO> recommendSelectAll(String member_id, String category);
	
	//마감임박 액티비티 리스트
	public List<ActivityVO> imminentSelectAll(String member_id);
	
	// 5
}
