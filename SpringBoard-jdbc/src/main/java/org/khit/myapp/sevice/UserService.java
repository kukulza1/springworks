package org.khit.myapp.sevice;

import org.khit.myapp.dto.UserDTO;
import org.khit.myapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class UserService {
  private  UserRepository ur;
	public void save(UserDTO userDTO) {
      		ur.save(userDTO);
	}
	public boolean login(UserDTO userDTO) {
		UserDTO loginuser =  ur.login(userDTO);
		if(loginuser != null) {
			return true;
		}else {
		return false;
		}
	}

}
