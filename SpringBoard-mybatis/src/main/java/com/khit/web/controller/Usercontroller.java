package com.khit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.web.dto.UserDTO;
import com.khit.web.service.UserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j              
@RequestMapping("/user")
@Controller
public class Usercontroller {
	
	@Autowired
	private UserService us;
	
	@GetMapping("/join")
	public String joinform() {
		return "/user/join";
	}
	@PostMapping("/join")
   public String join(@ModelAttribute UserDTO userDTO) {
		log.info("userDTO="+userDTO);
		us.insert(userDTO);
		return "redirect:/";
	}
	
	
   
}
