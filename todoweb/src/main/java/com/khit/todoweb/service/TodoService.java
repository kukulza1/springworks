package com.khit.todoweb.service;

import java.util.List;

import com.khit.todoweb.DTO.PageRequestDTO;
import com.khit.todoweb.DTO.PageResponseDTO;
import com.khit.todoweb.DTO.TodoDTO;

public interface TodoService {

	void insert(TodoDTO todoDTO);

	List<TodoDTO> getAll();

	TodoDTO findById(Long tno);

	void update(TodoDTO todoDTO);

	void delete(Long tno);

	PageResponseDTO<TodoDTO> pagingList(PageRequestDTO prd);

}
