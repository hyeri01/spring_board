package org.bbs.service;

import java.util.List;

import org.bbs.mapper.BoardMapper;
import org.bbs.model.BoardDTO;
import org.bbs.page.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	// connection �� �κ��� Mybatis�� �ѱ�
	// interface�� ���� mapper�� �ְ� > �� mapper�� interface ������ > xml(sql��)���� ����
	public BoardMapper bMapper;
	
	@Override
	public void boardInsert(BoardDTO dto) {
		
		bMapper.boardInsert(dto);

	}

	@Override
	public void boardDelete(Long bod_no) {
		bMapper.boardDelete(bod_no);
		
	}

	@Override
	public List<BoardDTO> boardListAll() {
		return bMapper.boardListAll();
	}

	@Override
	public BoardDTO boardContent(Long bod_no) {
		return bMapper.boardContent(bod_no);
	}

	@Override
	public void boardUpdate(BoardDTO dto) {
		bMapper.boardUpdate(dto);
	}

	@Override
	public List<BoardDTO> boardListPaging(Criteria cri) {
		return bMapper.boardListPaging(cri);
	}

	@Override
	public int getTotal() {
		return bMapper.getTotal();
	}

}
