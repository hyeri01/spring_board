package org.bbs.page;

public class Criteria {
	
	private int pageNum;
	// ���� ������ 
	
	private int amount;
	// �� ������ �� ������ �Խù� ���� 
	
	private int skip;
	// ��ŵ �� �Խù� ��( (pageNum-1) * amount )
	
	public Criteria() {
		this(1,10);
		this.skip = 0;
		// ó�� �Խù��� ������ 1 page���� 10���� �Խù��� ���δ� 
		// ex) select * from board limit 0(skip), 10(amount)
	}
	// �⺻ ������ -> �⺻ ���� : pageNum = 1 | amount = 10 
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum-1)*amount;
		// skip -> 
	}
	// ������ -> ���ϴ� pageNum, ���ϴ� amount

	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.skip = (pageNum-1) * this.amount;
		this.pageNum = pageNum;
	}
	// ����ڰ� �������� �ѱ� ������ skip ���� ����

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
