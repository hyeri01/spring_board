package org.bbs.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
// 자바와 웹 브라우저를 이어주는 단
public class UploadController {
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		System.out.println("uploadForm 진입 성공");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile, Model model) {
		
		String uploadFolder = "C:\\upload";
		
		
		for(MultipartFile multipartFile : uploadFile) {
			String originFileName = multipartFile.getOriginalFilename();
			System.out.println("---------------------");
			System.out.println("업로드된 파일 이름 : " + originFileName);
			System.out.println("업로드된 파일 크기: " + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, originFileName);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("File upload Fail");
			}
		}
		
	}
	
	
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		System.out.println("uploadAjax 진입 성공");
	}
	
	@PostMapping("/uploadAjaxAction")
	@ResponseBody
	public void uploadAjaxAction(MultipartFile[] uploadFile, Model model) {
		
		String uploadFolder = "C:\\upload";
		
		
		for(MultipartFile multipartFile : uploadFile) {
			String originFileName = multipartFile.getOriginalFilename();
			System.out.println("---------------------");
			System.out.println("업로드된 파일 이름 : " + originFileName);
			System.out.println("업로드된 파일 크기: " + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, originFileName);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("File upload Fail");
			}
		}
		
		
		
		
	}
	
	
	

	
}
