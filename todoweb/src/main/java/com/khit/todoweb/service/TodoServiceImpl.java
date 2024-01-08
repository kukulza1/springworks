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
		//DTO�� VO�� ��ȯ�ؾ���
		//1.���(ModelMapper)�����Ұ��
		/*TodoVO todoVO = TodoVO.builder()
				      .title(todoDTO.getTitle())
				      .writer(todoDTO.getWriter())
				      .build();*/
		
		//2.�����(ModelMapper)
		TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class);
		
		
		todoMapper.insert(todoVO);
	}
	@Override
	public List<TodoDTO> getAll() {
		//�̹��� VO�� DTO�� ��ȯ DB->��������
		List<TodoVO> tvlist = todoMapper.getAll();
		
		List<TodoDTO> tdlist = tvlist.stream().map(vo -> modelMapper.map(vo,TodoDTO.class))
				                              .collect(Collectors.toList());
				           
		return tdlist ;
	}

}








