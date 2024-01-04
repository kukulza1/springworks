package com.khit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.web.dto.ReplyDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/reply")
@Controller
public class ReplyController {
	
	@PostMapping("/insert")
	public String replyInsert(@ModelAttribute ReplyDTO replyDTO) {
		log.info("rdto="+replyDTO);
		return "redirect:/board?id="+replyDTO.getBoardId();
		
	}
	
	

}
