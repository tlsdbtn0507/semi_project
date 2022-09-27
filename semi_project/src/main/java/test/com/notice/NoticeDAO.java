package test.com.notice;

import java.util.List;

public interface NoticeDAO {

	// 알림 등록  
	public int insert(NoticeVO vo);

	// 알림 삭제  
	public int delete(long notice_id);
	
	// 알림 리스트
	public List<NoticeVO> selectAll(String member_id);
	
	// 액티비티 시작/종료
	public int activity_notice(long member_id);

}
