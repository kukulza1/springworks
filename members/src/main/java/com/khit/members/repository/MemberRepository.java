package com.khit.members.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.khit.members.DTO.MemberDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class MemberRepository {
	
	 private SqlSessionTemplate sst;

	public void insert(MemberDTO memberDTO) {
		sst.insert("Member1.insert",memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) {
		return sst.selectOne("Member1.login",memberDTO);	
	}
}



























