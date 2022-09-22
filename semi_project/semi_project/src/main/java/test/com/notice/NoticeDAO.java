package test.com.notice;

import java.util.List;

public interface NoticeDAO {

	// 알림 등록  
	public int insert(NoticeVO vo);

	// 알림 리스트
	public List<NoticeVO> selectAll();
}
