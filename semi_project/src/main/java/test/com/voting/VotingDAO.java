package test.com.voting;

import java.util.List;

public interface VotingDAO {

	//투표 등록    2
	public int insert(VotingVO vo);

	// 투표 수정하기  1
	public int update(VotingVO vo);

	// 투표 삭제하기  1
	public int delete(VotingVO vo);

	// 투표 리스트    1
	public List<VotingVO> selectAll();
	
	// 5
}
