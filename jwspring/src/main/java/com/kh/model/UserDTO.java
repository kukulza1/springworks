package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@ToString
@AllArgsConstructor //매개변수가 있는생성자
@NoArgsConstructor //매개변수가 없는 생성자
@Setter
@Getter
public class UserDTO {
	//필드
	private String name;
	private int age;

}
