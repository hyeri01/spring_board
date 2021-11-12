package org.bbs.page;

public class Criteria {
	
	private int pageNum;
	// 현재 페이지 
	
	private int amount;
	// 한 페이지 당 보여질 게시물 갯수 
	
	private int skip;
	// 스킵 할 게시물 수( (pageNum-1) * amount )
	
	public Criteria() {
		this(1,10);
		this.skip = 0;
		// 처음 게시물이 열리면 1 page에서 10개의 게시물이 보인다 
		// ex) select * from board limit 0(skip), 10(amount)
	}
	// 기본 생성자 -> 기본 세팅 : pageNum = 1 | amount = 10 
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum-1)*amount;
		// skip -> 
	}
	// 생성자 -> 원하는 pageNum, 원하는 amount

	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.skip = (pageNum-1) * this.amount;
		this.pageNum = pageNum;
	}
	// 사용자가 페이지를 넘길 때마다 skip 값은 변경

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.skip = (pageNum-1) * this.amount;
		this.amount = amount;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", skip=" + skip + "]";
	}

	
	
	
	

	
}
