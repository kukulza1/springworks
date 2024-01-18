package com.khit.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khit.board.dto.BoardDTO;

@Repository
public class BoardRepository {
	//지원메서드-insert(), update(), delete(), selectList(), selectOne()
	@Autowired
	private SqlSessionTemplate sql;

	public void insert(BoardDTO boardDTO) {
		sql.insert("Board1.insert",boardDTO);
	}

	public List<BoardDTO> findAll() {
		
		return sql.selectList("Board1.findAll");
	}

	public BoardDTO findById(Integer id) {
		return sql.selectOne("Board1.findById",id);
	}

	public void delete(Integer id) {
		 sql.delete("Board1.delete",id);
	}

	public void update(BoardDTO boardDTO) {
        sql.update("Board1.update",boardDTO);		
	}
	
	

}
