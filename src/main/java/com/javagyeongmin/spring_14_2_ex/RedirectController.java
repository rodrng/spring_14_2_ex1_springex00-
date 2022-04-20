package com.javagyeongmin.spring_14_2_ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller; // *전부다 말고 Controller만 불러와도 됨
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 컨트롤러 사용하려면 임포트 시켜줘야한다
public class RedirectController {
	
	@RequestMapping("/index1")
	public String goIndex() {
		
		return "index1";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String goStudent(HttpServletRequest httpservletRequest, Model model) {
		
		String pid = httpservletRequest.getParameter("id");
		
		if(pid.equals("tiger")) {
			
			return "redirect:studentOk";//view의 이름(jsp이름)이 아니라 요청 url
		}
		
		return "redirect:studentNg";
	}
	
	@RequestMapping(value = "/studentOk")
	public String studentOk() {
		return "student/studentOk";
	}
	
	@RequestMapping(value = "/studentNg")
	public String studentNg() {
		return "student/studentNg";
	}
	
	@RequestMapping(value = "/feel")
	public String goFeel() {
		
		return "redirect:http://localhost:8888/spring_14_2_ex/good";
	}
	
	@RequestMapping(value = "/good")
	public String goGood() {
		return "good";
	}
	
	
}
