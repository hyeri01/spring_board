package org.bbs.boardtest;

import java.util.List;

import org.bbs.mapper.MemberListMapper;
import org.bbs.model.MemberListDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberListMapperTest {

	@Autowired
	private MemberListMapper memberMapper;
	
	//@Test
	public void memberInsert() {
		MemberListDTO dto = new MemberListDTO();
		
		dto.setMem_name("�Ϲ�");
		dto.setMem_tel("010-1111-1111");
		dto.setMem_addr("�뱸������ �޼��� ����");
		dto.setMem_age("13");
		dto.setMem_gender("��");
		
		memberMapper.memberInsert(dto);
	}
	
	@Test
	public void memberListAll() {
		List<MemberListDTO> list = memberMapper.memberListAll();
		
		for(MemberListDTO i : list) {
			System.out.println(i);
		}
	}
	
	@Test
	public void memberAccount() {
		MemberListDTO dto = memberMapper.memberAccount(1L);
		System.out.println(dto);
	}
	
	//@Test
	public void memberDelete() {
		memberMapper.memberDelete(1L);
	}
	
	@Test
	public void memberUpdate() {
		MemberListDTO dto = new MemberListDTO();
		
		dto.setMem_name("������");
		dto.setMem_tel("010-1234-1234");
		dto.setMem_addr("����������");
		dto.setMem_age("15");
		dto.setMem_gender("��");
		dto.setMem_no(3L);
		
		memberMapper.memberUpdate(dto);
	}
}
