package com.kh.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.model.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Usercontroller {
	
	@GetMapping("/user")
	public void user() {
		System.out.println("user test.");
		log.info("usertest22");
	
		
	}
	//GetMapping - get방식의 경로 설정 어노테이션
	 @GetMapping("/user/info")
	 public String userinfo() {
		 return"user/info"; //user/info.jsp
	 }
	 
	 //http://localhost:8080/user/ex01?name = &age=
	 @GetMapping("user/ex01")
	 public String getUser(UserDTO dto) {
		 log.info("" + dto); //객체가드가서 오류 빈문자열 넣어줌
		 return "user/ex01"; //user/ex01.jsp
	 }
	 
	 @GetMapping("user/ex02")
	 public String getUser(@RequestParam("name") String name,
			 @RequestParam("age") int age) {
		 log.info("이름:"+name);
		 log.info("나이:"+age);
		 return "user/ex02";
	 }

}














