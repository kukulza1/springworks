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

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;
import com.khit.web.dto.ReplyDTO;
import com.khit.web.service.BoardService;
import com.khit.web.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

//@AllArgsConstructor  //������ ����
@Slf4j
@RequestMapping("/board")
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private ReplyService replyService;
	
	//�۾��� ������
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	//�۾���
	@PostMapping("/write")
	public String write(BoardDTO boardDTO) {
		log.info("boardDTO=" + boardDTO);
		boardService.insert(boardDTO);
		return "redirect:/board/paging"; //boardlist.jsp�� �̵�
	}
	
	//�۸��
	@GetMapping("/")
	public String getList(Model model) {
		List<BoardDTO> boardDTOList = boardService.findall();
		model.addAttribute("boardlist",boardDTOList);
		return "board/boardlist";
	}
	
	//�۸��(������ó��)
	// /board/paging?page=2
	// @RequestParam(required=true/false) false�� �ʼ��ƴ�
	@GetMapping("/paging")
	public String getPageList(Model model,
			@RequestParam(value="page",required=false, defaultValue="1") 
	        int page) {
		//log.info("page="+page);
		//�������� �� ������ ������ ��Ϻ���
		List<BoardDTO> pagingList = boardService.pagingList(page);
		//log.info("paginglist="+ pagingList);
		model.addAttribute("boardlist", pagingList);
		
		PageDTO pageDTO = boardService.pagingParam(page);
		model.addAttribute("paging", pageDTO);
		return "/board/pagelist";
	}
	
	//�ۻ󼼺���
	//board?id=
	@GetMapping
	public String getBoard(@RequestParam("id") Long id,
			 Model model,@RequestParam(value="page",required=false, defaultValue="1") 
    int page) {
		//��ȸ�� ����
		boardService.updateHit(id);
		List<ReplyDTO> replyList = replyService.getReplyList(id);
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		model.addAttribute("replyList", replyList);
		model.addAttribute("page", page);
		return"/board/detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id")Long id) {
		boardService.delete(id);
		return "redirect:/board/";		
	}
	
	@GetMapping("/update")
	public String updateform(@RequestParam("id")Long id, Model model) {
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "/board/updateboard";	
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO) {
		boardService.update(boardDTO);
		return "redirect:/board/update?id="+boardDTO.getId();
		
	}
	
}











