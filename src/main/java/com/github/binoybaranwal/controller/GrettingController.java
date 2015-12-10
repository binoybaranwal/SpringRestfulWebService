package com.github.binoybaranwal.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.github.binoybaranwal.pojo.Greeting;

@EnableWebMvc
@RestController
public class GrettingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
		
	@RequestMapping(value = "/greeting", method=RequestMethod.GET)	
	public Greeting greeting(@RequestParam(value="name", defaultValue="World", required=false) String name){				
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
		return greeting;
	}		
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ModelAndView defaultPage(){		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

}
