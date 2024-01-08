package com.khit.todoweb.mapper;

import java.util.List;

import com.khit.todoweb.VO.TodoVO;

public interface TodoMapper {
	
	public String getTime();
	public void insert(TodoVO todoVO);
	
	List<TodoVO> getAll();

}
