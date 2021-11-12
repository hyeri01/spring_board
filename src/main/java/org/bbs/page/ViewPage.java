package org.bbs.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/*화면에 표시되는 페이징*/
public class ViewPage {

	
	/* 시작 페이지 */
	private int startPage;
	
	/* 끝 페이지 */
	private int endPage;
	
	/* 이전 페이지, 다음 페이지 존재유무 */
	private boolean prev;
	private boolean next;
	
	/* 전체 게시물 수 */
	private int total;
	
	/* 현재 페이지, 페이지당 게시물 표시 수 정보 */
	private Criteria cri;
	
	
	public ViewPage(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		/* 마지막 페이지 */
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		
		/* 시작 페이지 */
		this.startPage = this.endPage - 9;
		
		/* 전체 마지막 페이지 */
		int realEnd = (int)(Math.ceil(total * 1.0/cri.getAmount()));
		
		/*
		 * 전체 마지막 페이지(realend)가 화면에 보이는 마지막 페이지(endPage)보다 작은 경우, 보이는 페이지(endPage) 값 조정
		 */
		if(realEnd < this.endPage) {
			// 만약 realEnd 값이, 현재의 endPage보다 작다면 
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
		/* realEnd(끝 페이지)인데 endPage의 다음 버튼이 생기면 안 되기 때문에 */
	}
	
	
}
