package org.hoshi.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.hoshi.dto.GalleryDTO;
import org.hoshi.service.GalleryService;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GalleryController {
	
	@Resource(name="galleryService")
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
		//System.out.println(dto.getGtitle());
		//System.out.println(dto.getGcontent());
		//System.out.println(upFile.getOriginalFilename());
		if(request.getSession().getAttribute("mid")!=null) {
			String newFileName = util.fileUpload(upFile);
			dto.setGfile(newFileName);
			int result = galleryService.galleryInsert(dto);
			System.out.println("결과 : "+result);
			return "redirect:/gallery";
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/galleryDetail@{no}")
	public String galleryDetail(@PathVariable("no") String no, Model model) {
		System.out.println(no);
		int gno = util.str2Int(no);
		GalleryDTO dto = galleryService.galleryDetail(gno);
		model.addAttribute("detail",dto);
		return "galleryDetail";
	}
	
	@PostMapping("/galleryDel")
	public String galleryDel(@RequestParam("no") int no) {
		if(util.getSession().getAttribute("mid")!=null) {
			int result = galleryService.galleryDel(no);
			if(result==1) {
				return "redirect:/gallery"; 
			} else {
				return "redirect:/error";
			}
		} else {
			return "redirect:/login";
		}
	}
}
