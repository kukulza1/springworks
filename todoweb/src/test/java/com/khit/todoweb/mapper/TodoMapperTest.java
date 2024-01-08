package com.khit.todoweb.mapper;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khit.todoweb.VO.TodoVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class TodoMapperTest {
	
	@Autowired //자동주입 - todomapper가 객체가됨 new와같음
	private TodoMapper todoMapper;
	
	@Test
	public void testGetTime() {
		todoMapper.getTime();
		log.info("test="+todoMapper.getTime());
	}
	
	@Test
	public void testInsert() {
		//데이터1개생성 - setter -> builder() 
		
		/*TodoVO todoVO = new TodoVO() ;
		//todoVO.setTno(1L);
		todoVO.setTitle("12전");
		todoVO.setWriter("영우킹13");
		//todoVO.setCreatedDate(new Timestamp(System.currentTimeMillis()));*/
		
		/*TodoVO todoVO = TodoVO.builder()
				    .title("운동중")
				    .writer("영우.")				    
				    .build();
		
		todoMapper.insert(todoVO);*/
		
		
	}
	@Test
	public void testgetAll() {
	List<TodoVO> tv =	todoMapper.getAll();
	
	for(TodoVO todo : tv) {
		log.info(todo);
	}
	
	}
	

}
