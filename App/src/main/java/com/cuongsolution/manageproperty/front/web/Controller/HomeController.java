package com.cuongsolution.manageproperty.front.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
//production controller
public class HomeController {
	@GetMapping(value="/")
	public String home( )  {
		return "redirect:/quan-ly";
    }
}
