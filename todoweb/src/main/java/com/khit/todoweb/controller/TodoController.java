package com.khit.todoweb.controller;

import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.todoweb.DTO.PageRequestDTO;
import com.khit.todoweb.DTO.PageResponseDTO;
import com.khit.todoweb.DTO.TodoDTO;
import com.khit.todoweb.service.TodoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@RequestMapping("/todo")
@Controller
public class TodoController {
	
	
	private TodoService todoService;
	
	@GetMapping("/register")
	public String registerform() {
		
		return "/todo/register";
		
	}
	@PostMapping("/register")
	public String register(@ModelAttribute TodoDTO todoDTO) {
		
		log.info("todoDTO="+todoDTO);
		todoService.insert(todoDTO);
		return "index";
		
	}
	@GetMapping("/list")
	public String list(Model model) {
		List<TodoDTO> todoDTO =  todoService.getAll();
		
		model.addAttribute("todolist", todoDTO);
		return "/todo/list";
		
	}
	
	@GetMapping // /todo?tno=1
	public String getTodo(@RequestParam("tno") Long tno,PageRequestDTO pageRequestDTO
			,Model model) {
		TodoDTO todoDTO = todoService.findById(tno);
		model.addAttribute("todo", todoDTO);
		return "/todo/detail";
		
	}
	
	@GetMapping("/updatetodo")
	public String updateform(@RequestParam("tno") Long tno,Model model) {
		TodoDTO todoDTO = todoService.findById(tno);
		model.addAttribute("todo", todoDTO);
		return"/todo/updatetodo";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("tno") Long tno) {
		todoService.delete(tno);
		
		return"redirect:/todo/list";
		
	}
	
	@PostMapping("/update")
	public String updatetodo(@ModelAttribute TodoDTO todoDTO) {
		todoService.update(todoDTO);
		
		return "redirect:/todo/updatetodo?tno="+todoDTO.getTno();
		
	}
	
	@GetMapping("/paging")
	public String todopagingList(@ModelAttribute  PageRequestDTO RequestDTO, Model model) {
		
	PageResponseDTO<TodoDTO> responseDTO =
		todoService.pagingList(RequestDTO);
		model.addAttribute("responseDTO", responseDTO);
		return "/todo/pagelist";
	}

}













