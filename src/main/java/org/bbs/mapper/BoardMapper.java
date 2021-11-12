package org.bbs.mapper;

import java.util.List;

import org.bbs.model.BoardDTO;
import org.bbs.page.Criteria;

public interface BoardMapper {
	
	/* 게시판 등록 */
	public void boardInsert(BoardDTO dto);
	// xml에서 sql문 실행
	
	/* 게시판 목록 */
	public List<BoardDTO> boardListAll();
	
	/* 게시판 목록(페이징 적용) */
	public List<BoardDTO> boardListPaging(Criteria cri);
	
	/* 게시판 조회 */
	public BoardDTO boardContent(Long bod_no);
	
	/* 게시판 삭제 */
	public void boardDelete(Long bod_no);
	
	/* 게시판 수정 */
	public void boardUpdate(BoardDTO dto);
	
	/* 게시판 총 갯수 */
	public int getTotal();

}
