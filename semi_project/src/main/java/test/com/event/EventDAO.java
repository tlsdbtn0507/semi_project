package test.com.event;

import java.util.List;

public interface EventDAO {

	// 이벤트 등록   1  
	public int insert(EventVO vo);

	// 이벤트 수정하기   1
	public int update(EventVO vo);

	// 이벤트 삭제하기   1
	public int delete(EventVO vo);

	// 이벤트 목록    1
	public List<EventVO> selectAll();
	
	// 4
}
