package org.bbs.mapper;

import java.util.List;

import org.bbs.model.BoardDTO;
import org.bbs.page.Criteria;

public interface BoardMapper {
	
	/* �Խ��� ��� */
	public void boardInsert(BoardDTO dto);
	// xml���� sql�� ����
	
	/* �Խ��� ��� */
	public List<BoardDTO> boardListAll();
	
	/* �Խ��� ���(����¡ ����) */
	public List<BoardDTO> boardListPaging(Criteria cri);
	
	/* �Խ��� ��ȸ */
	public BoardDTO boardContent(Long bod_no);
	
	/* �Խ��� ���� */
	public void boardDelete(Long bod_no);
	
	/* �Խ��� ���� */
	public void boardUpdate(BoardDTO dto);
	
	/* �Խ��� �� ���� */
	public int getTotal();

}
