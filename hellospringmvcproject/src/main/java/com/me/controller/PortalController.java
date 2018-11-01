package com.me.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/portal")
public class PortalController {
	
   @RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView index() {
	   ModelAndView modelAndView = new ModelAndView();
	   modelAndView.setViewName("portal/index");
	 

	   return modelAndView;
	}
   
   @RequestMapping(value="/test",method=RequestMethod.GET)
   @ResponseBody
	public String test() {
	  
	   return "hello world";
	}

}
