package com.mytest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
		
	@RequestMapping(value="/hello")
	public @ResponseBody String hello(){
		return "Hello World";
	}
	
	@RequestMapping(value="/")
	public String test(){
		return "index";
	}
	
	@RequestMapping(value="/update")
	public String update(){
		return "update";
	}
	
	@RequestMapping(value="/add")
	public String add(){
		return "add";
	}
	
	@RequestMapping(value="/home")
	public String home(){
		return "home";
	}
	
	@RequestMapping(value="/delete")
	public String delete(){
		return "delete";
	}

}
