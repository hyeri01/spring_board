package org.bbs.service;

import java.util.List;

import org.bbs.model.MemberListDTO;

public interface MemberListService {
	
	public void memberInsert(MemberListDTO dto);
	
	public List<MemberListDTO> memberListAll();
	
	public MemberListDTO memberAccount(Long mem_no);
	
	public void memberDelete(Long mem_no);
	
	public void memberUpdate(MemberListDTO dto);

}
