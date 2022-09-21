package test.com.notice;

import java.util.List;

public interface NoticeDAO {

	// 알림 등록    1
	public int insert(NoticeVO vo);

	// 알림 리스트   1
	public List<NoticeVO> selectAll();
	
	// 2
}
