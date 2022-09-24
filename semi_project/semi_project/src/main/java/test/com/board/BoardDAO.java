package test.com.board;

import java.util.List;

public interface BoardDAO {
	
	// 게시판 작성하기
	public int createBoard(BoardVO vo);
	// 게시판 수정하기
	public int update(BoardVO vo);
	// 공지 등록하기
	public boolean notice (BoardVO vo);
	// 게시판 글 목록
	public List<BoardVO> selectAll();
	// 글 검색하기
	public List<BoardVO> searchList(String key, String value);
}
