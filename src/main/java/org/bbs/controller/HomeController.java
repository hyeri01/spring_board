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
// 자바와 웹 브라우저를 이어주는 단
public class HomeController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private MemberListService memberService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	// 같은 이름이라도 method 방식이 다르기 때문에 다르게 인식한다
	@GetMapping("/register")
	public String GoRegister() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(BoardDTO dto) {
		
		// 로직 구현 (boardService를 구현해 놓았으니 dto 사용해서 로직 실행해라)
		boardService.boardInsert(dto);
		
		return "redirect:/";
	}
	
	
//	home으로 다시 돌아가길 원한다면 redirect해 줘야 한다. -> redirect:/ = redirect:(주소)로 가 달라는 의미
	
	
	
	@GetMapping("/boardList")
	public String GoBoardList(Model model, Criteria cri) {
		//model => add.attribute (속상 값을 담아 출력할 수 있다)
		
		List<BoardDTO> boardList = boardService.boardListPaging(cri); 
		// list 형태로 출력
		model.addAttribute("boardList", boardList);
		// 이름, list
		
		int total = boardService.getTotal();
		ViewPage viewPage = new ViewPage(cri, total);
		model.addAttribute("viewPage", viewPage);
		
		return "boardList";
	}
	
	
	@GetMapping("/boardContent")
	public String GoBoardContent(@RequestParam("bod_no")String ubod_no, Model model) {
		//model => add.attribute (속상 값을 담아 출력할 수 있다)
		
		Long bod_no = Long.parseLong(ubod_no);
		BoardDTO dto = boardService.boardContent(bod_no);
		
		model.addAttribute("dto", dto);
		
		return "boardContent";
	}
	
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bod_no")String ubod_no) {
		
		Long bod_no = Long.parseLong(ubod_no);
		// String 값 Long 값으로 변환
		
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
		// return 위해 bod_no 값
		
		boardService.boardUpdate(dto);
		
		// 로직 구현 (boardService를 구현해 놓았으니 dto 사용해서 로직 실행해라)
		
		
		return "redirect:/boardContent?bod_no=" + bod_no;
	}
	
	
	

	
	
	
	
	
	
	
	// 회원 테이블 
	
	@GetMapping("/join")
	public String GoJoin() {
		return "join";
	}
	
	
	@PostMapping("/join")
	public String join(MemberListDTO dto) {
		
		// 로직 구현 (boardService를 구현해 놓았으니 dto 사용해서 로직 실행해라)
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
	
	
	// 삭제
	
	@GetMapping("/memDelete")
	public String memDelete(@RequestParam("mem_no")String umem_no) {
		
		Long mem_no = Long.parseLong(umem_no);
		memberService.memberDelete(mem_no);
		
		return "redirect:/memberList";
	}
	
	// 수정
	
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
