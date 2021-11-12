package org.bbs.service;

import java.util.List;

import org.bbs.mapper.MemberListMapper;
import org.bbs.model.MemberListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberListServiceImpl implements MemberListService {

	@Autowired
	public MemberListMapper mMapper;
	
	
	// select
	@Override
	public List<MemberListDTO> memberListAll() {
		
		System.out.println("222222222222222");	
		
		return mMapper.memberListAll();
	}


	// 상세 페이지
	@Override
	public MemberListDTO memberAccount(Long mem_no) {
		return mMapper.memberAccount(mem_no);
	}


	// insert
	@Override
	public void memberInsert(MemberListDTO dto) {
		mMapper.memberInsert(dto);
	}


	// delete
	@Override
	public void memberDelete(Long mem_no) {
		mMapper.memberDelete(mem_no);
	}


	@Override
	public void memberUpdate(MemberListDTO dto) {
		mMapper.memberUpdate(dto);
		
	}

}
