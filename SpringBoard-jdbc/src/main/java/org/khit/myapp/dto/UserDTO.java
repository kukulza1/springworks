package org.khit.myapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class UserDTO {
	
	private Long id;
	private String userid;
	private String userpasswd;
	private String username;
	private Integer userage;
	

}
