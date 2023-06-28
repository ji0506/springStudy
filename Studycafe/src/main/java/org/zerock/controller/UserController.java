package org.zerock.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.User;
import org.zerock.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/*")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("/main.do")
	public String list() {
		
		return "/member/login";
	}
	
	
	@RequestMapping("/login.do")
	public String login(ModelMap model,HttpServletRequest request, User user) {
		
		
		User user2 = service.getLoginUser(user.getUserId());
		
		
		String hashedPassword = sha256Hash(user.getUserPwd());
		
		if(user2.getUserPwd().equals(hashedPassword)){
			request.getSession().setAttribute("userId", user.getUserId());
			//로그인 성공시 접속날짜 업데이트. sql에서 SYSDATE() 또는 now() 함수를 써도됨
			Date utilDate = new Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());				
			
		}
		
		return "redirect:/main/main.do";
	}


	
	
	public static String sha256Hash(String input) {
	    try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
	
	        // 해시 값을 16진수 문자열로 변환
	        StringBuilder hexString = new StringBuilder();
	        for (byte b : hash) {
	            String hex = Integer.toHexString(0xff & b);
	            if (hex.length() == 1) {
	                hexString.append('0');
	            }
	            hexString.append(hex);
	        }
	
	        return hexString.toString();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
