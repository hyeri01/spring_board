package org.bbs.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/*ȭ�鿡 ǥ�õǴ� ����¡*/
public class ViewPage {

	
	/* ���� ������ */
	private int startPage;
	
	/* �� ������ */
	private int endPage;
	
	/* ���� ������, ���� ������ �������� */
	private boolean prev;
	private boolean next;
	
	/* ��ü �Խù� �� */
	private int total;
	
	/* ���� ������, �������� �Խù� ǥ�� �� ���� */
	private Criteria cri;
	
	
	public ViewPage(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		/* ������ ������ */
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		
		/* ���� ������ */
		this.startPage = this.endPage - 9;
		
		/* ��ü ������ ������ */
		int realEnd = (int)(Math.ceil(total * 1.0/cri.getAmount()));
		
		/*
		 * ��ü ������ ������(realend)�� ȭ�鿡 ���̴� ������ ������(endPage)���� ���� ���, ���̴� ������(endPage) �� ����
		 */
		if(realEnd < this.endPage) {
			// ���� realEnd ����, ������ endPage���� �۴ٸ� 
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
		/* realEnd(�� ������)�ε� endPage�� ���� ��ư�� ����� �� �Ǳ� ������ */
	}
	
	
}
