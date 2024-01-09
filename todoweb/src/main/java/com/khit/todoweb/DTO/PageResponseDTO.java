package com.khit.todoweb.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResponseDTO<E> { //목록과 페이지 이동을 위한DTO
	//제네릭으로 만드는이유 - 회원정보,게시판 객체를 페이지 처리할수 있음
		
    private int startpage;
	
	private int endpage;
	
	private boolean prev;
	
	private boolean next;
	
	private int page;
	private int size;
	
	private int total;
	
	//목록데이터
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
		
		//total -83인경우 ->8.3 ->9.3 ->9
		int maxpage =(int)(Math.ceil((double)total/size));
		if(endpage>maxpage)
			endpage = maxpage;
		//이전
		this.prev = this.startpage>1;
		//다음
		this.next = total > this.endpage*this.size;
		}

}
