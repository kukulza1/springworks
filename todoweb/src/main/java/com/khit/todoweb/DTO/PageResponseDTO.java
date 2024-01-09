package com.khit.todoweb.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResponseDTO<E> { //��ϰ� ������ �̵��� ����DTO
	//���׸����� ��������� - ȸ������,�Խ��� ��ü�� ������ ó���Ҽ� ����
		
    private int startpage;
	
	private int endpage;
	
	private boolean prev;
	
	private boolean next;
	
	private int page;
	private int size;
	
	private int total;
	
	//��ϵ�����
	private List<E> dtoList;
	
	
	@Builder(builderMethodName = "whitAll")
	public PageResponseDTO(PageRequestDTO pageRequestDTO, 
		List<E> dtoList, int total) {
		this.page = pageRequestDTO.getPage();
		this.size = pageRequestDTO.getSize();
		
		this.total = total;
		this.dtoList = dtoList;
		
		this.endpage = (int)(Math.ceil((double)this.page/10))*10;
		this.startpage = this.endpage -9;
		
		//total -83�ΰ�� ->8.3 ->9.3 ->9
		int maxpage =(int)(Math.ceil((double)total/size));
		if(endpage>maxpage)
			endpage = maxpage;
		//����
		this.prev = this.startpage>1;
		//����
		this.next = total > this.endpage*this.size;
		}

}
