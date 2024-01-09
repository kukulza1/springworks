package com.khit.todoweb.mapper;

import java.util.List;

import com.khit.todoweb.DTO.PageRequestDTO;
import com.khit.todoweb.DTO.TodoDTO;
import com.khit.todoweb.VO.TodoVO;

public interface TodoMapper {
	
	public String getTime();
	
	public void insert(TodoVO todoVO);
	
	List<TodoVO> getAll();
	
	
	
	public TodoVO findById(Long tno);

	public void delete(Long tno);

	public void update(TodoVO todoVO);
	
	List<TodoVO> pagingList(PageRequestDTO pagerequestDTO);
	public int todoCount();

	
	
   

}
