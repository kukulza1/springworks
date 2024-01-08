package com.khit.todoweb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		//�����Էµ� �ڷ�� �����ؼ� DB�� �����׽�Ʈ
		TodoDTO todoDTO = TodoDTO.builder()
				             .title("����222")
				             .writer("����222")
				             .build();
		todoService.insert(todoDTO);
	}

}
