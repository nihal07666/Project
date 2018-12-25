package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Category;
import com.niit.service.ProductService;

@Controller
public class PageController {
	@Autowired
	private ProductService productService;

	
	@RequestMapping("/")
	public String getIndexPage(Model model)
	{
		List<Category> categories=productService.getAllCategories();
		model.addAttribute("categories",categories);
		return "index";
	}
	@RequestMapping("/aboutus")
	public String getAboutusPage()
	{
		return"aboutus";
	}
	@RequestMapping("/ContactUs")
	public String getContactUsPage()
	{
		return"ContactUs";
	}
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/loginerror")
	public String loginError(Model model){
		model.addAttribute("loginError","Invalid email/password");
		return "login";
	}
	@RequestMapping(value="/logout")
	public String logout(Model model){
		model.addAttribute("message","Loggedout successfully..");
		return "login";
	}


	
}
