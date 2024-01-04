package com.khit.web.mapper;

import java.util.List;

import com.khit.web.dto.BoardDTO;

public interface BoardMapper {

	void insert(BoardDTO boardDTO);

	List<BoardDTO> findall();

	BoardDTO findById(Long id);

	void updateHit(Long id);

	void delete(Long id);

	void update(BoardDTO boardDTO);

	

}
