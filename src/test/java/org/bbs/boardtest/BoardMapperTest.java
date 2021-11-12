package org.bbs.boardtest;

import java.util.List;

import org.bbs.mapper.BoardMapper;
import org.bbs.model.BoardDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void boardinsert() {
		
		for(int i = 1; i<=1000; i++) {
			BoardDTO dto = new BoardDTO();
			dto.setBod_title(i + "번 제목입니다.");
			dto.setBod_content(i + "번 내용입니다.");
			dto.setBod_password(1234);
			dto.setBod_writer("admin");
			
			boardMapper.boardInsert(dto);
		}
		
	}
	
	@Test
	public void boardListAll() {
		List<BoardDTO> list = boardMapper.boardListAll();
		
		boardMapper.boardListAll().forEach(i -> log.info(i));
		
		for(BoardDTO i : list) {
			System.out.println(i);
		}
	}
	
	@Test
	public void boardDelete() {
		boardMapper.boardDelete(1001L);
	}
	
	@Test
	public void boardContet() {
		BoardDTO dto = boardMapper.boardContent(1L);
		System.out.println(dto);
	}
	
	@Test
	public void boardupdate() {
		BoardDTO dto = new BoardDTO();
		
		dto.setBod_title("수정");
		dto.setBod_content("수정 성공");
		dto.setBod_password(1111);
		dto.setBod_writer("admin");
		dto.setBod_no(998L);
		
		
		boardMapper.boardUpdate(dto);
	}
	
	
	
}
