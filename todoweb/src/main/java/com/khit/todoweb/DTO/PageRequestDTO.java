package com.khit.todoweb.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PageRequestDTO { //파라메터(page,kw) 수집용DTO
	
	
	private int page =1 ;
	private int size= 15; //페이지당 게시글수
	
	private String[] types; //검색유형
	private String keyword; //검색어
	
	
	public int getSkip() { //#{skip}
		return (page -1)*10; //1p-0, 2p-10
	}

	

}
