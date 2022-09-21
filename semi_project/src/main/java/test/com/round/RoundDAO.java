package test.com.round;

import java.util.List;

public interface RoundDAO {
	
	// 라운드 개설하기   1
	public int insert(RoundVO vo);
	// 라운드 수정하기   1
	public int update(RoundVO vo);
	// 라운드 리스트     1
	public List<RoundVO> selectAll();
	// 라운드 검색하기    1
	public List<RoundVO> searchList(String key, String value);
	
	
	// 4
}