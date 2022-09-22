package test.com.voting;

import java.util.List;

public interface VotingDAO {

	// 조 편성 
	public int insert(VotingVO vo);

	// 조 수정하기
	public int update(VotingVO vo);

	// 조 삭제하기
	public int delete(VotingVO vo);

	// 조 리스트
	public List<VotingVO> selectAll();
}
