package org.hoshi.service;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class MailService2 {

	public void sendTextMail(String email, String title, String content) throws EmailException {
		String emailAddr = "";	//얘는 보내는 사람 주소 - outlook
		String name = "서버에서 보냄"; // 보내는 사람 이름
		String pw = "";	//보내는 계정 비번
		String host = "smtp-mail.outlook.com";	//아웃룩 호스트
		int port = 587;		//아웃룩 포트
		
		SimpleEmail mail = new SimpleEmail();
		mail.setCharset("UTF-8"); // 언어셋
		mail.setDebug(true); // 디버그
		mail.setHostName(host); // 호스트 = 아웃룩
		mail.setAuthentication(emailAddr, pw);// 보내는 사람 이메일 주소, 비밀번호
		mail.setSmtpPort(port); // 보내는 포트
		mail.setFrom(emailAddr, name);// 보내는 사람의 주소, 이름
		mail.setStartTLSEnabled(true);// 인증방법
		mail.addTo(email); // 받는 사람 === 파라미터로
		mail.setSubject(title); //제목 ==== 파라미터로
		mail.setMsg(content); // 내용 ===== 파라미터로
		mail.send(); //발송
	}

	public void sendHtmlMail(String email, String title, String content) throws EmailException {
		String emailAddr = "";	//얘는 보내는 사람 주소 - outlook
		String name = "서버에서 보냄"; // 보내는 사람 이름
		String pw = "";	//보내는 계정 비번
		String host = "smtp-mail.outlook.com";	//아웃룩 호스트
		int port = 587;		//아웃룩 포트
		
		HtmlEmail mail = new HtmlEmail();
		mail.setCharset("UTF-8");
		mail.setDebug(true);
		mail.setHostName(host);
		mail.setAuthentication(emailAddr, pw); //인증 방법
		mail.setSmtpPort(port);
		mail.setFrom(emailAddr, name); //보내는사람 주소, 보내는사람
		mail.setStartTLSEnabled(true);
		mail.addTo(email); //받는 사람- 파라미터로 받음
		mail.setSubject(title);	//제목 - 파라미터로 받음
		mail.setMsg(content); // 내용 - 파라미터로 받음
		
		//파일 첨부도 가능하대.
		EmailAttachment file = new EmailAttachment();
		file.setPath("c:\\temp\\pixeled.gif");
		mail.attach(file);
		
		
		
		mail.send();
		
	}

}
