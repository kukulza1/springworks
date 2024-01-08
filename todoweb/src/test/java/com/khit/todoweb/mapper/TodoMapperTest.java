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
	
	@Autowired //�ڵ����� - todomapper�� ��ü���� new�Ͱ���
	private TodoMapper todoMapper;
	
	@Test
	public void testGetTime() {
		todoMapper.getTime();
		log.info("test="+todoMapper.getTime());
	}
	
	@Test
	public void testInsert() {
		//������1������ - setter -> builder() 
		
		/*TodoVO todoVO = new TodoVO() ;
		//todoVO.setTno(1L);
		todoVO.setTitle("12��");
		todoVO.setWriter("����ŷ13");
		//todoVO.setCreatedDate(new Timestamp(System.currentTimeMillis()));*/
		
		/*TodoVO todoVO = TodoVO.builder()
				    .title("���")
				    .writer("����.")				    
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
