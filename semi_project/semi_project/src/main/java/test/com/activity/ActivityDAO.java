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

	// 액티비티 검색하기
	public List<ActivityVO> searchList(String key, String value);
}
