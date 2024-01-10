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
public class AjaxController { //ajax ��ûó�� ��Ʈ�ѷ�
	
	@GetMapping("/ex01")
	public String ex01() {
		log.info("GET ��ûó��");
		return "/ajax-ex/main";
		
	}
	//@ResponseBody ���ڿ��� ��ȯ
	@PostMapping("/ex02")
	public @ResponseBody String ex02() {
		log.info("POST ��ûó��");
		return "/ajax-ex/main";
		
	}
	
	@GetMapping("/ex03")
	public @ResponseBody String ex03(@RequestParam("greet") String greet,
			                     @RequestParam("num") int num) {
		log.info("GET ������ó��"+greet);
		log.info("GET ������ó��"+num);
		return "success";
		
	}
	//ajaxdto - ��ü�̸���json���� ��ȯ������ jackson-databind�� �����������
	@PostMapping("/ex04")
	public @ResponseBody AjaxDTO ex04(@ModelAttribute AjaxDTO ajaxDTO) {
		log.info("POST dtoó��"+ajaxDTO);
		return ajaxDTO;
		
	}

}








