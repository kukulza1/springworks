package com.khit.todoweb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.khit.todoweb.DTO.TodoDTO;
import com.khit.todoweb.VO.TodoVO;
import com.khit.todoweb.mapper.TodoMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService{
      TodoMapper todoMapper;
      private ModelMapper modelMapper;
	@Override
	public void insert(TodoDTO todoDTO) {
		//DTO를 VO로 변환해야함
		//1.모듈(ModelMapper)사용안할경우
		/*TodoVO todoVO = TodoVO.builder()
				      .title(todoDTO.getTitle())
				      .writer(todoDTO.getWriter())
				      .build();*/
		
		//2.모듈사용(ModelMapper)
		TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class);
		
		
		todoMapper.insert(todoVO);
	}
	@Override
	public List<TodoDTO> getAll() {
		//이번엔 VO를 DTO로 변환 DB->브라우저로
		List<TodoVO> tvlist = todoMapper.getAll();
		
		List<TodoDTO> tdlist = tvlist.stream().map(vo -> modelMapper.map(vo,TodoDTO.class))
				                              .collect(Collectors.toList());
				           
		return tdlist ;
	}

}








