package org.hoshi.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hoshi.dto.GalleryDTO;
import org.hoshi.service.GalleryService;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	@Autowired
	private Util util;
	
	@GetMapping("/gallery")
	public String gallery(Model model) {
		List<GalleryDTO> list = galleryService.galleryList();
		model.addAttribute("list", list);
		return "gallery";
	}
	
	@GetMapping("/galleryInsert")
	public String galleryInsert() {
		return "galleryInsert";
	}
	
	@PostMapping("/galleryInsert")
	public String galleryInsert(GalleryDTO dto, @RequestParam("file1") MultipartFile upFile, HttpServletRequest request) {
		System.out.println(dto.getGtitle());
		System.out.println(dto.getGcontent());
		System.out.println(upFile.getOriginalFilename());
		
		String newFileName = util.fileUpload(upFile);
		dto.setGfile(newFileName);
		
		int result = galleryService.galleryInsert(dto);
		
		System.out.println("결과 : "+result);
		return "galleryInsert";
	}
}
