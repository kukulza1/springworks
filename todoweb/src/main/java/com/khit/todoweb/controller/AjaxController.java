package com.khit.todoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.todoweb.DTO.AjaxDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AjaxController { //ajax 요청처리 컨트롤러
	
	@GetMapping("/ex01")
	public String ex01() {
		log.info("GET 요청처리");
		return "/ajax-ex/main";
		
	}
	//@ResponseBody 문자열로 반환
	@PostMapping("/ex02")
	public @ResponseBody String ex02() {
		log.info("POST 요청처리");
		return "/ajax-ex/main";
		
	}
	
	@GetMapping("/ex03")
	public @ResponseBody String ex03(@RequestParam("greet") String greet,
			                     @RequestParam("num") int num) {
		log.info("GET 데이터처리"+greet);
		log.info("GET 데이터처리"+num);
		return "success";
		
	}
	//ajaxdto - 객체이르모json으로 변환을위해 jackson-databind를 주입해줘야함
	@PostMapping("/ex04")
	public @ResponseBody AjaxDTO ex04(@ModelAttribute AjaxDTO ajaxDTO) {
		log.info("POST dto처리"+ajaxDTO);
		return ajaxDTO;
		
	}

}








