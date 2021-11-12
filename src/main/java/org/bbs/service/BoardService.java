package org.bbs.service;

import java.util.List;

import org.bbs.model.BoardDTO;
import org.bbs.page.Criteria;

public interface BoardService {
	
	//	interface이니 구현체가 있을 것이며,
	public void boardInsert(BoardDTO dto);
	
	public void boardDelete(Long bod_no);
	
	public List<BoardDTO> boardListAll();
	
	/* 게시판 목록(페이징 적용) */
	public List<BoardDTO> boardListPaging(Criteria cri);
	
	public BoardDTO boardContent(Long bod_no);
	
	public void boardUpdate(BoardDTO dto);
	
	public int getTotal();

}
