package com.koreaIT.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsrHomeController {
	
	@RequestMapping("usr/home/main")
	public String showMain() {
		return "usr/home/main";
	}
	
	@RequestMapping("/")
	public String showRoot() {
		return "redirect:/usr/home/main";
	}
	
	@RequestMapping("/usr/home/popUp")
	public String popUp() {
		return "/usr/home/popUp";
	}
	
	@RequestMapping("/usr/home/checkboxTest")
	public String checkboxTest() {
		return "/usr/home/checkboxTest";
	}
	
	@RequestMapping("/usr/home/checkboxSubmit")
	public String checkboxSubmit(Model model, @RequestParam(name = "ids", required = false) List<String> ids) {
		
		model.addAttribute("ids", ids);
		
		return "/usr/home/checkboxSubmit";
	}
}