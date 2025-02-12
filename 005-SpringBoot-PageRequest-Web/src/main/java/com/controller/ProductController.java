package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Product;
import com.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String landingPage(Model model, HttpSession session)
	{
		List<Product> pList = service.getAllRecords();
		System.out.println(pList);
		long count = service.CountRecords();
		model.addAttribute("data", pList);
		model.addAttribute("totalcount", count);
		session.setAttribute("flag", false);
		
		
		
		return "index";
	}
	
	@RequestMapping("/first-page")
	public String firstPage(Model model)
	{
		List<Product> pList = service.getFirstPage();
		System.out.println(pList);
		model.addAttribute("data", pList);
		return "index";
	}
	
	@RequestMapping("/second-page")
	public String secondPage(Model model)
	{
		List<Product> pList = service.getSecondPage();
		System.out.println(pList);
		model.addAttribute("data", pList);
		return "index";
	}
	
	@RequestMapping("/lowtohigh")
	public String lowToHigh(Model model)
	{
		List<Product> pList = service.lowToHigh();
		System.out.println(pList);
		model.addAttribute("data", pList);
		return "index";
	}
	
	@RequestMapping("/search-by-name")
	public String searchByName(@RequestParam String text, Model model,HttpSession session)
	{
		List<Product> pList = service.getProductByName(text);
		long count1 = pList.size();
	
	
		long count = service.CountRecords();
		
		System.out.println(count+"----"+count1);
		System.out.println(pList);
		model.addAttribute("data", pList);
		model.addAttribute("totalcount", count);
		model.addAttribute("searchcount", count1);
		session.setAttribute("flag", true);
		return "index";
	}
	
	
	
}
