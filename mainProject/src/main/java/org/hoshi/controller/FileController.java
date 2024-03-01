package org.hoshi.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class FileController {
	
	@GetMapping("/file")
	public String file() {
		return "file";
	}
	
	@PostMapping("/file")
	public String file(@RequestParam("file1") MultipartFile upFile, HttpServletRequest request) {
//		System.out.println("파일 이름 : "+upFile.getOriginalFilename());
//		System.out.println("파일 사이즈 : "+upFile.getSize());
//		System.out.println("파일 타입 : "+upFile.getContentType());
		
//		경로
		String root = request.getSession().getServletContext().getRealPath("/");
		System.out.println("root : "+root);
		String upfile = root+"resources\\upfile\\";
		System.out.println("upfile : "+upfile);
		String thumbnailRoot = root+"resources\\thumbnail\\";
		
//		uuid 생성
		UUID uuid = UUID.randomUUID();
		String newFileName = uuid.toString()+"-"+upFile.getOriginalFilename();
		
		//Real Upload
		File f = new File(upfile, newFileName);
		try {
			//이게 뭘까 - 그냥 파일 전송하는 애.
			
			//썸네일 만들기
			FileOutputStream thumbnail = new FileOutputStream(new File(thumbnailRoot,"s_"+newFileName));
			Thumbnailator.createThumbnail(upFile.getInputStream(),thumbnail,100,100);
			//실제 올라갈 파일, 저장할 경로, 가로, 세로
			thumbnail.close();
			
			upFile.transferTo(f);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/file";
	}

}
