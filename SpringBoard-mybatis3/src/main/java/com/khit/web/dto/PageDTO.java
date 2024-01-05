package com.khit.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Data
public class PageDTO {
	
	private int page;        //현재페이지
	private int startPage;   //현재페이지 기준 시작 페이지 값
	private int maxPage;     //최대페이지(게시글의총개수에따른 페이지)
	private int endPage;     //현재페이지 기준 마지막 페이지 값

}





























