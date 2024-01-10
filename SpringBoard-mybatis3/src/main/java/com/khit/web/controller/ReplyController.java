package com.khit.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.web.dto.ReplyDTO;
import com.khit.web.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/reply")
@Controller
public class ReplyController {
	
	//서비스 클래스 주입(생성자,autowired)
	@Autowired
	private ReplyService replyService;
	@PostMapping("/insert")
	public @ResponseBody List<ReplyDTO> replyInsert(
			@ModelAttribute ReplyDTO replyDTO ) {
		
		replyService.insert(replyDTO);
		log.info("rdto="+replyDTO);
		//등록후 댓글 목록가져와서 detailpage로 보내줌
		List<ReplyDTO> replyList = replyService.getReplyList(replyDTO.getBoardId());

		return replyList;
		
	}
	
	@GetMapping("/delete")
	public String replyDelete(@RequestParam("boardId") Long boardId,
			 @RequestParam("id") Long id) {
		replyService.delete(id);
		return "redirect:/board?id="+boardId;
		
	}
	@GetMapping("/update")
	public String replyUpdateform(@RequestParam("boardId") Long boardId,
			 @RequestParam("id") Long id, Model model) {
		ReplyDTO replyDTO = replyService.findById(id);
		model.addAttribute("reply", replyDTO);
		return "/board/updatereply";
		
	}
	
	@PostMapping("/update")
	public String replyupdate(@ModelAttribute ReplyDTO replyDTO) {
		replyService.update(replyDTO);
		
		return "redirect:/board?id="+replyDTO.getBoardId();
		
	}
	
	

}
