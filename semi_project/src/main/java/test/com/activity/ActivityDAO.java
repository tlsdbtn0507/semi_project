package test.com.activity;

import java.util.List;

public interface ActivityDAO {

	// 액티비티 개설하기
	public int insert(ActivityVO vo);

	// 액티비티 수정하기
	public int update(ActivityVO vo);

	// 액티비티 삭제하기
	public int delete(ActivityVO vo);

	// 액티비티 리스트
	public List<ActivityVO> selectAll();
//<<<<<<< HEAD
//=======
//	
//	// 내 액티비티 전체 리스트
//	public List<ActivityVO> mySelectAll(String member_name, String activityState);
//	
//	// 액티비티 추천 리스트      1
////	public List<ActivityVO> selectAll();
//>>>>>>> 0574ae638d7fa4a00e889ffeb0db092dac3d4166

	// 액티비티 검색하기
	public List<ActivityVO> searchList(String key, String value);

}
