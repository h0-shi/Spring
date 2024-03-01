package org.hoshi.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Component
public class Util {
	public int str2Int(String str) {
		if (str.matches("[0-9]+") && str != null) {
			return Integer.parseInt(str);
		} else {
			return 0;
		}
	}

	public HttpServletRequest req() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		return request;
	}

	public HttpSession getSession() {
		HttpSession session = req().getSession();
		return session;
	}

	// ip
	public String getIp() {
		HttpServletRequest request = req();
		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	public String replaceTag(String str) {
		str = str.replaceAll("<", "&lt");
		str = str.replaceAll(">", "&gt");
		str = str.replaceAll("(\r\n|\r|\n|\n\r)","<br>");
		return str;
	}

	public boolean intCheck(String str) {
		if (str.matches("[0-9]+") && str != null) {
			return true;
		} else {
			return false;
		}
	}
	
	// 메일보내기
		public void sendEmail(String email, String key) throws EmailException {
			// mail보내기
			//String emailAddr = MailInfo.emailID; // 이메일 주소
			//String name = "트리니티 코인"; // 이름
			//String passwd = MailInfo.emailPW; // 암호
			//String hostName = "smtp-mail.outlook.com"; // smpt
			//int port = 587; // 포트 번호

			SimpleEmail simpleEmail = new SimpleEmail(); // 전송할 메일
			simpleEmail.setCharset("UTF-8");
			simpleEmail.setDebug(true);
			simpleEmail.setHostName("smtp-mail.outlook.com"); // 보내는 서버 설정 = 고정
			simpleEmail.setAuthentication("", ""); // 보내는 사람 인증 = 고정
			simpleEmail.setSmtpPort(587); // 사용할 port = 고정
			simpleEmail.setStartTLSEnabled(true); // 인증방법 = 고정
			simpleEmail.setFrom("", "트리니티 코인"); // 보내는 사람 email, 보내는 사람 이름 = 고정
			simpleEmail.addTo(email); // 받는 사람
			simpleEmail.setSubject("트리니티 코인 인증번호입니다");// 제목
			simpleEmail.setMsg("인증번호는 [" + key + "] 입니다"); // 본문내용 text
			simpleEmail.send(); // 전송
		}

		public String createKey() {
			Random r = new Random();
			r.setSeed(System.currentTimeMillis());
			String key = "" + r.nextInt(10) +  r.nextInt(10) + r.nextInt(10) + r.nextInt(10);
			return key;
		}
		
		public String file(@RequestParam("file1") MultipartFile upFile, HttpServletRequest request) {
//			System.out.println("파일 이름 : "+upFile.getOriginalFilename());
//			System.out.println("파일 사이즈 : "+upFile.getSize());
//			System.out.println("파일 타입 : "+upFile.getContentType());
			
//			경로
			String root = request.getSession().getServletContext().getRealPath("/");
			System.out.println("root : "+root);
			String upfile = root+"resources\\upfile\\";
			System.out.println("upfile : "+upfile);
			String thumbnailRoot = root+"resources\\thumbnail\\";
			
//			uuid 생성
			UUID uuid = UUID.randomUUID();
			String newFileName = uuid.toString()+"-"+upFile.getOriginalFilename();
			
			System.out.println("upfile : "+upfile+newFileName);
			
			String newRoot = upfile+newFileName;
			
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
			return newRoot;
		}

		public String fileUpload(MultipartFile upFile) {
			//경로 저장
			String root = req().getSession().getServletContext().getRealPath("/");
			String upFilePath = root+"resources\\upfile\\";
			String thumbnailRoot = root+"resources\\thumbnail\\";
//			UUID 만들기
			UUID uuid = UUID.randomUUID();
			//UUID 포함한 파일명
			String newFileName = uuid.toString()+upFile.getOriginalFilename();
			//업로드
			File file = new File(upFilePath, newFileName); //경로명,파일명
			//경로가 없아면 만들어주기
			if(file.exists()==false) {
				file.mkdirs();
			}
			try {
				FileOutputStream thumbnail = new FileOutputStream(new File(thumbnailRoot,"s_"+newFileName));
				Thumbnailator.createThumbnail(upFile.getInputStream(),thumbnail,310,167);
				upFile.transferTo(file);
				thumbnail.close();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return newFileName;
		}
	
}
