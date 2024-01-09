package com.khit.todoweb.service;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.khit.todoweb.DTO.PageResponseDTO;
import com.khit.todoweb.DTO.TodoDTO;
import com.khit.todoweb.VO.TodoVO;
import com.khit.todoweb.mapper.TodoMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoServiceImpl<PageRequestDTO> implements TodoService{
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
		List<TodoDTO> todolist = new ArrayList<>();
		for(TodoVO todoVO : tvlist) {
					
		TodoDTO todoDTO = TodoDTO.builder()
				          .tno(todoVO.getTno())
				          .title(todoVO.getTitle())
				          .writer(todoVO.getWriter())
				          .build();
		todolist.add(todoDTO);
		}
		return todolist ;
		
		
		/*List<TodoVO> tvlist = todoMapper.getAll();
		 * List<TodoDTO> tdlist = tvlist.stream().map(vo -> modelMapper.map(vo,TodoDTO.class))
				                              .collect(Collectors.toList());
		  return tdlist ;*/
				           

	}
	@Override
	public TodoDTO findById(Long tno) {
		//Vo�������ͼ� DTO�κ�ȯ
		TodoVO todoVO = todoMapper.findById(tno);
		/*TodoDTO todoDTO = TodoDTO.builder()
		          .tno(todoVO.getTno())
		          .title(todoVO.getTitle())
		          .writer(todoVO.getWriter())
		          .build();*/
		TodoDTO todoDTO = modelMapper.map(todoVO,TodoDTO.class);
          return  todoDTO ;			
	}
	
	@Override
	public void update(TodoDTO todoDTO) {
		TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class);
		todoMapper.update(todoVO);
	}
	
	@Override
	public void delete(Long tno) {
		todoMapper.delete(tno);
	}
	
	
	@Override
	public PageResponseDTO<TodoDTO> pagingList(com.khit.todoweb.DTO.PageRequestDTO pageRequestDTO) {
		
         List<TodoVO> voList = todoMapper.pagingList(pageRequestDTO);
		
		List<TodoDTO> dtoList =voList.stream().map(vo-> modelMapper.map(vo,TodoDTO.class))
				              .collect(Collectors.toList()); 
		
		 int total= todoMapper.todoCount();
		PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>whitAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO).build();
		
		return pageResponseDTO;
	}
	
	
				                                   
	
	

}








