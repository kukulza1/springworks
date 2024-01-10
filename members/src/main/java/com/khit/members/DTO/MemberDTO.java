package com.khit.members.DTO;
import lombok.Data;

@Data
public class MemberDTO {
	
	private Long id;
	private String email;
	private String passwd;
	private String name;
	private int age;

}
