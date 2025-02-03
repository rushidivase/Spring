package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Student;
import com.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService service;

	@RequestMapping("/")
	public String landingPage() {
		return "index";
	}

	@RequestMapping("/register")
	public String registerPage() {
		System.out.println("Register Page Called..!");
		return "register";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/login-check")
	public String loginCheck(@RequestParam String username, @RequestParam String password, Model model) {
		List<Student> sList = service.loginCheck(username, password);
		System.out.println(sList);

		if (!sList.isEmpty()) {
			model.addAttribute("data", sList);
			return "success";
		} else {
			return "login";
		}

	}

	@RequestMapping("/save-student")
	public String saveStudent(@ModelAttribute Student stu) {
		System.out.println("Student in Controller:" + stu);
		service.saveStudent(stu);
		return "register";
	}
	
	@RequestMapping("/delete-student")
	public String deleteStudent(@RequestParam int sid, Model model)
	{
		List<Student> sList = service.deleteById(sid);
		
		if (!sList.isEmpty()) {
			model.addAttribute("data", sList);
			return "success";
		} else {
			return "login";
		}
	}
}
