package org.bbs.controller;

import java.util.List;

import org.bbs.model.BoardDTO;
import org.bbs.model.MemberListDTO;
import org.bbs.page.Criteria;
import org.bbs.page.ViewPage;
import org.bbs.service.BoardService;
import org.bbs.service.MemberListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// �ڹٿ� �� �������� �̾��ִ� ��
public class HomeController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private MemberListService memberService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	// ���� �̸��̶� method ����� �ٸ��� ������ �ٸ��� �ν��Ѵ�
	@GetMapping("/register")
	public String GoRegister() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(BoardDTO dto) {
		
		// ���� ���� (boardService�� ������ �������� dto ����ؼ� ���� �����ض�)
		boardService.boardInsert(dto);
		
		return "redirect:/";
	}
	
	
//	home���� �ٽ� ���ư��� ���Ѵٸ� redirect�� ��� �Ѵ�. -> redirect:/ = redirect:(�ּ�)�� �� �޶�� �ǹ�
	
	
	
	@GetMapping("/boardList")
	public String GoBoardList(Model model, Criteria cri) {
		//model => add.attribute (�ӻ� ���� ��� ����� �� �ִ�)
		
		List<BoardDTO> boardList = boardService.boardListPaging(cri); 
		// list ���·� ���
		model.addAttribute("boardList", boardList);
		// �̸�, list
		
		int total = boardService.getTotal();
		ViewPage viewPage = new ViewPage(cri, total);
		model.addAttribute("viewPage", viewPage);
		
		return "boardList";
	}
	
	
	@GetMapping("/boardContent")
	public String GoBoardContent(@RequestParam("bod_no")String ubod_no, Model model) {
		//model => add.attribute (�ӻ� ���� ��� ����� �� �ִ�)
		
		Long bod_no = Long.parseLong(ubod_no);
		BoardDTO dto = boardService.boardContent(bod_no);
		
		model.addAttribute("dto", dto);
		
		return "boardContent";
	}
	
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bod_no")String ubod_no) {
		
		Long bod_no = Long.parseLong(ubod_no);
		// String �� Long ������ ��ȯ
		
		boardService.boardDelete(bod_no);
		
		return "redirect:/boardList";
	}
	
	
	@GetMapping("/edit")
	public String GoBoardUpdate(@RequestParam("bod_no")String ubod_no, Model model) {
		
		Long bod_no = Long.parseLong(ubod_no);
		BoardDTO dto = boardService.boardContent(bod_no);
		model.addAttribute("dto", dto);
		
		return "edit";
	}
	
	@PostMapping("/update")
	public String update(BoardDTO dto, @RequestParam("bod_no") String bod_no) {
		// return ���� bod_no ��
		
		boardService.boardUpdate(dto);
		
		// ���� ���� (boardService�� ������ �������� dto ����ؼ� ���� �����ض�)
		
		
		return "redirect:/boardContent?bod_no=" + bod_no;
	}
	
	
	

	
	
	
	
	
	
	
	// ȸ�� ���̺� 
	
	@GetMapping("/join")
	public String GoJoin() {
		return "join";
	}
	
	
	@PostMapping("/join")
	public String join(MemberListDTO dto) {
		
		// ���� ���� (boardService�� ������ �������� dto ����ؼ� ���� �����ض�)
		memberService.memberInsert(dto);
		
		return "redirect:/memberList";
	}
	

	@GetMapping("/memberList")
	public String GoMemberList(Model model) {
		System.out.println("111111111111111111");	
		
		
		List<MemberListDTO> memberList = memberService.memberListAll();
		model.addAttribute("memberList", memberList);
		
		return "memberList";
	}
	
	@GetMapping("/memberAccount")
	public String GoMemberAccount(@RequestParam("mem_no")String umem_no, Model model) {
		
		Long mem_no = Long.parseLong(umem_no);
		MemberListDTO dto = memberService.memberAccount(mem_no);
		
		System.out.println("1011111111111111111111");
		System.out.println(dto);
		
		model.addAttribute("dto", dto);
		
		
		return "memberAccount";
	}
	
	
	// ����
	
	@GetMapping("/memDelete")
	public String memDelete(@RequestParam("mem_no")String umem_no) {
		
		Long mem_no = Long.parseLong(umem_no);
		memberService.memberDelete(mem_no);
		
		return "redirect:/memberList";
	}
	
	// ����
	
	@GetMapping("/editAccount")
	public String editAccount(@RequestParam("mem_no")String umem_no, Model model) {
		Long mem_no = Long.parseLong(umem_no);
		MemberListDTO dto = memberService.memberAccount(mem_no);
		model.addAttribute("dto", dto);
		
		return "editAccount";
	}
	
	@PostMapping("/memUpdate")
	public String update(MemberListDTO dto) {
		memberService.memberUpdate(dto);
		
		return "redirect:/memberAccount?mem_no=" + dto.getMem_no();
	}
	
	
	
	
	
	

	
}
