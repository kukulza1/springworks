package com.khit.web.service;

import org.springframework.stereotype.Service;

import com.khit.web.dto.BoardDTO;
import com.khit.web.mapper.BoardMapper;
@Service
public class BoardServiceimpl implements BoardService{

	BoardMapper bm;
	@Override
	public void insert(BoardDTO boardDTO) {
		bm.insert(boardDTO);
		
	}

}
