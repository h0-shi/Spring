package com.hoshi.web.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hoshi.web.service.IndexService;
import com.hoshi.web.util.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	@Autowired
	private Util util;
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Map<String, Object>> menu = indexService.menu();
		model.addAttribute("menu",menu);
		return "index";
	}
	
	@GetMapping("/")
	public String index2(Model model) {
		return index(model);
	}
	
	@GetMapping("/freeboard")
	public String freeboard(@RequestParam(name="cate", defaultValue = "1",required = false) int cate, Model model) {
		//메뉴 불러오기
		List<Map<String, Object>> fb = indexService.freeBoard(cate);
		List<Map<String, Object>> menu = indexService.menu();
		model.addAttribute("cateName",indexService.cateName(cate));
		model.addAttribute("menu",menu);
		model.addAttribute("fb",fb);
		return "freeboard";
	}
	
	@GetMapping("/write")
	public String write(Model model) {
		HttpSession session = util.getSession();
		if(session.getAttribute("mname")!=null || session.getAttribute("mid")!=null) {
			List<Map<String, Object>> menu = indexService.menu();
			model.addAttribute("menu",menu);
			return "write";
		}
		return "redirect:/login";
	}
	
	@PostMapping("/write")
	public String write(@RequestParam Map<String, Object> map) {
		//System.out.println(map);
		HttpSession session = util.getSession();
		if(session.getAttribute("mname")!=null || session.getAttribute("mid")!=null) {
			int result = indexService.write(map);
			//System.out.println(result);
			return "freeboard";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("no") int no, Model model) {
		List<Map<String, Object>> menu = indexService.menu();
		model.addAttribute("menu",menu);
		Map<String, Object> detail = indexService.detail(no);
		model.addAttribute("detail",detail);
		return "detail";
	}
	
	@PostMapping("/postDel")
	public String postDel(@RequestParam("no") int no, @RequestParam("cate") int cate) {
		HttpSession session = util.getSession();
		if(session.getAttribute("mname")!=null || session.getAttribute("mid")!=null) {
			int result = indexService.postDeil(no);
			switch(cate) {
			case 1 :
				return "redirect:/freeboard";
			case 2:
				return "redirect:/notice?no=2";
			case 3 :
				return "redirect:/notice?no=3";
			case 4 :
				return "redirect:/notice?no=4";
			case 5 :
				return "redirect:/notice?no=5";
			case 6 :
				return "redirect:/notice?no=6";
			default :
				return "redirect:/index";
			}
		} return "redirect:/login";
		
	}
	
	@GetMapping("/postUpdate")
	public String postUpdate(@RequestParam("mtno") int mtno, Model model) {
		HttpSession session = util.getSession();
		if(session.getAttribute("mname")!=null || session.getAttribute("mid")!=null) {
			Map<String, Object> detail = indexService.detail(mtno);
			List<Map<String, Object>> menu = indexService.menu();
			model.addAttribute("menu",menu);
			model.addAttribute("detail",detail);
			return "update";
		} else {
			return "redirect:/login";
		}
	}
	
	@PostMapping("/postUpdate")
	public String postUpdate(@RequestParam Map<String, Object> map) {
		HttpSession session = util.getSession();
		String mname = session.getAttribute("mname")+"";
		if(mname == map.get("mname")) {
			int result = indexService.postUpdate(map);
			return "redirect:/detail?no="+map.get("mtno");
		}
		return "redirect:/login";
	}
	
	@GetMapping("/fileUp")
	public String fileUp() {
		return "fileUp";
	}

	@PostMapping("/fileUp")
	public String fileUp(@RequestParam("fileUp") MultipartFile file) {
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getOriginalFilename());

		// String url = util.req().getServletContext().getRealPath("/upload");
		File url = new File(util.req().getServletContext().getRealPath("/upload"));
		url.mkdirs();
		// UUID를 붙이던지
		// 년월일시분초
		// 나노초
		// 파일 업로드시 UUID+실제 파일명.확장자
		// 파일 다운로드시 원래 파일명.확장자 ----------

		// UUID
		UUID uuid = UUID.randomUUID();
		System.out.println("원본 파일명 : " + file.getOriginalFilename());// 청소.jpg
		System.out.println("UUID 파일명 : " + uuid.toString() + file.getOriginalFilename());
														// 14a78e6c-3aa8-4710-a27e-6dee34fc462f청소.jpg

		// 날짜를 뽑아서 파일명 변경하기
		LocalDateTime ldt = LocalDateTime.now();
		String ldtFormat = ldt.format(DateTimeFormatter.ofPattern("YYYYMMddHHmmSS"));
		System.out.println("날짜 파일명 : " + ldtFormat + file.getOriginalFilename());// 20240312100903청소.jpg

		File upFileName = new File(url, ldtFormat + file.getOriginalFilename());

		try {
			file.transferTo(upFileName);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("실제 경로 : " + url);

		return "redirect:/fileUp";
	}

	//downfile@파일명
	@ResponseBody
	@GetMapping("/downfile@{file}") //path variable
	public void down(@PathVariable("file") String file, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("경로에 들어온 파일명 : " + file);
		String url = "/static/img/";
		//File url = new File(util.req().getServletContext().getRealPath("/upload"));
		File serverFile = new File(url, file);
		
		try {
			byte[] fileByte  = FileCopyUtils.copyToByteArray(serverFile);
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; fileName=\""+ URLEncoder.encode(url+file, "UTF-8")+"\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
