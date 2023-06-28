package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.SimpleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleContoller {

	
	
	@RequestMapping("/list.do")
	public String basic() {
		log.info("basic.................");
		
		System.out.println("bbb");
		return "/home";
	}
	
	@GetMapping
	public void basicGet2() {
		log.info(log);
	}
	
	@GetMapping("/ex01")
	public String DTO(SimpleDTO dto) {
		log.info(" " + dto);
		return "home";
	}
	
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name")String name, @RequestParam("age") int age) {
		log.info(" " + name + "," + age );
		return "home";
	}

	@GetMapping("/ex03List")
	public String ex02(@RequestParam("ids") ArrayList<String> list) {
		log.info(" " + list);
		return "home";
	}

	
	
	@GetMapping("/ex02List")
	public String ex02(@RequestParam("ids") String[] list) {
		log.info(" " + Arrays.toString(list));
		return "home";
	}
	
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info(" " + list);
		return "home";
	}


	
	@GetMapping("/ex04")
	public String ex04(Model model,SimpleDTO dto, @ModelAttribute("page") int page) {
		
		log.info(" " + dto + ", " + page);
		
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
		
		
		return "sample/ex04";
	}
	@GetMapping("/ex06")
	@ResponseBody
	public SimpleDTO ex06() {
		log.info("......ex06" );

		SimpleDTO dto = new SimpleDTO();
		dto.setAge(18);
		dto.setName("홍길동");
		
		
		return dto;	
	}

	
}
