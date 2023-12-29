package com.khit.web.mapper;

import com.khit.web.dto.UserDTO;

//sql을 처리할 메퍼 인터페이스(추상메서드 선언)
public interface UserMapper {
	

	public void insert(UserDTO userDTO);

}
