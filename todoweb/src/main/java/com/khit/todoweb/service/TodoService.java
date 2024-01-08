package com.khit.todoweb.service;

import java.util.List;

import com.khit.todoweb.DTO.TodoDTO;

public interface TodoService {

	void insert(TodoDTO todoDTO);

	List<TodoDTO> getAll();

}
