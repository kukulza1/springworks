package com.khit.web;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class MybatisTest {
	//try~ resource문- close()를사용하지 않음
	@Autowired
	private SqlSessionFactory sql;
	
	@Test
	public void testMybatis() {
		try(SqlSession session =sql.openSession()){
			Connection conn = session.getConnection();
			log.info("session="+session);
			log.info("conn="+conn);
		}catch(Exception e) {
			e.getMessage();
		}
	}

}
