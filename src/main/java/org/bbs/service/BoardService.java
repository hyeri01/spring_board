package org.bbs.service;

import java.util.List;

import org.bbs.model.BoardDTO;
import org.bbs.page.Criteria;

public interface BoardService {
	
	//	interface�̴� ����ü�� ���� ���̸�,
	public void boardInsert(BoardDTO dto);
	
	public void boardDelete(Long bod_no);
	
	public List<BoardDTO> boardListAll();
	
	/* �Խ��� ���(����¡ ����) */
	public List<BoardDTO> boardListPaging(Criteria cri);
	
	public BoardDTO boardContent(Long bod_no);
	
	public void boardUpdate(BoardDTO dto);
	
	public int getTotal();

}
