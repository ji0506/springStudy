package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/main/*")
@AllArgsConstructor
public class MainController {

//	private BoardService service;

	@RequestMapping("/main.do")
	public String main(Model model) {
		
		
		model.addAttribute("katTargetNo", 0);
		model.addAttribute("katTargetName", "Dashboard");

		
		return "/main/main";
	}

}
