package com.khit.web.service;

import org.springframework.stereotype.Service;


import com.khit.web.dto.UserDTO;
import com.khit.web.mapper.UserMapper;

@Service
public class UserSeviceImpl implements UserService{
	
	private UserMapper umapper;

	@Override
	public void insert(UserDTO userDTO) {
		umapper.insert(userDTO);
	}

}
