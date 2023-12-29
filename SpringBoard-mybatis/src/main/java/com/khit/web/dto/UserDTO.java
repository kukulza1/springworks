package com.khit.web.dto;

import lombok.Data;

/*@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter*/
@Data
public class UserDTO {
	private Long Id;
	private String userId;
	private String userPasswd;
	private String userName;
	private String userAge;

}
