package org.khit.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class FileController {
	
	@GetMapping("/file/upload")
	public String uploadform() {
		return "/file/uploadform";
	}
	@PostMapping("/file/upload")
	public String upload(MultipartFile filename, Model model
			) throws IllegalStateException, IOException {
		
		long filesize = filename.getSize();
		String filetype = filename.getContentType();
		log.info("originfilename="+/*originfilename +*/",filesize="+filesize+",filetype="+filetype);
		
		//����������
		String savedFilename ="";
		if(!filename.isEmpty()) {
		String filepath = "C:\\springworks\\jwspring2\\src\\main\\webapp\\upload";
		
		 savedFilename =  filename.getOriginalFilename();//�������� ��������
		
		//�����̸� �ߺ����� ���� ID ��ü����
		UUID uuid = UUID.randomUUID();
		savedFilename = uuid.toString() + "_" + savedFilename;
		
		
		File file = new File(filepath+"\\"+savedFilename);
		filename.transferTo(file);
		}
		model.addAttribute("sfile", savedFilename);
		
		return "/file/uploadform";
	}

}








