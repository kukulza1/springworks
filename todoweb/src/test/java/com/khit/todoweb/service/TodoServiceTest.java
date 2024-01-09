package com.khit.todoweb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khit.todoweb.DTO.PageRequestDTO;
import com.khit.todoweb.DTO.PageResponseDTO;
import com.khit.todoweb.DTO.TodoDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class TodoServiceTest {
	
	@Autowired
	private TodoService todoService;
	
	
	@Test
	public void testinsert() {
		//폼에입력된 자료로 간주해서 DB에 저장테스트
		TodoDTO todoDTO = TodoDTO.builder()
				             .title("게임222")
				             .writer("영우222")
				             .build();
		todoService.insert(todoDTO);
	}
	@Test
	public void testppage() {
		PageRequestDTO prd = PageRequestDTO.builder()
				             .page(1)
				             .size(11)
				             .build();
		PageResponseDTO<TodoDTO> pageResponseDTO = todoService.pagingList(prd);
		//log.info(pageResponseDTO);
		//목록데이터출력
		pageResponseDTO.getDtoList().stream().forEach(todo -> log.info(todo));
	}

}
