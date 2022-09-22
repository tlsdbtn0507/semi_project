package test.com.Team;

import java.util.List;

public interface TeamDAO {

	// 조 편성 
	public int insert(TeamVO vo);

	// 조 수정하기
	public int update(TeamVO vo);

	// 조 삭제하기
	public int delete(TeamVO vo);

	// 조 리스트
	public List<TeamVO> selectAll();
}
