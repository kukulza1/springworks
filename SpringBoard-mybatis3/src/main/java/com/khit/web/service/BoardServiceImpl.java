package com.khit.web.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;
import com.khit.web.mapper.BoardMapper;


//@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public void insert(BoardDTO boardDTO) {
		boardMapper.insert(boardDTO);
	}

	@Override
	public List<BoardDTO> findall() {
		
		return boardMapper.findall();
	}

	@Override
	public BoardDTO findById(Long id) {
		return boardMapper.findById(id);
	}

	@Override
	public void updateHit(Long id) {
		boardMapper.updateHit(id);
	}

	@Override
	public void delete(Long id) {
		boardMapper.delete(id);
	}

	@Override
	public void update(BoardDTO boardDTO) {
		boardMapper.update(boardDTO);
	}
	
	int pageLimit = 10; // 페이지 당 글갯수
	int blockLimit = 15; //하단에보여줄 페이지 번호개수
	@Override
	public List<BoardDTO> pagingList(int page) {
		/* 1page-0, 2page-5, 3page-10
		 * select*from boards order by id asc limit startPage,pageLimit;
		 */
		
		int pageStart = (page-1)*pageLimit; //페이지 시작번호
		Map<String,Integer> pagingParam = new HashMap<>();
		pagingParam.put("start", pageStart);
		pagingParam.put("limit", pageLimit);
		List<BoardDTO> pagingList = boardMapper.pagingList(pagingParam);
		return pagingList;
	}

	@Override
	public PageDTO pagingParam(int page) {
		//하단에 보여줄 페이지 블럭
		int totalRow = boardMapper.boardCount(); //전체 게시글 수
		
		//전체페이지개수-올림(Math.cell) (게시글수)43/10 - 4.3 == 5페이지
		 int maxPage = (int)(Math.ceil((double)totalRow/pageLimit));
		 //하단에 보여줄 시작페이지 값 계산- 예)5개씩보임(1,6,11,16)
		 int startPage = ((int)(Math.ceil((double)page/blockLimit))-1)*blockLimit+1;
		 //하단에 보여줄 마지막 페이지값 계산(5,10,15,20)
		 int endPage= startPage + blockLimit -1 ;
		 if(endPage > maxPage) {
			 endPage = maxPage;
		 }
		 
		//빈객체를 생성해서 값을 세팅해주고 반환함
		 PageDTO pageDTO = new PageDTO();
		 
		 pageDTO.setPage(page);
		 pageDTO.setMaxPage(maxPage);
		 pageDTO.setStartPage(startPage);
		 pageDTO.setEndPage(endPage);
					
		return pageDTO;
	}

}
