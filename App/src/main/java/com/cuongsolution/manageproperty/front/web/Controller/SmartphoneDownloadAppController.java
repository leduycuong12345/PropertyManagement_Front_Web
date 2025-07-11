package com.cuongsolution.manageproperty.front.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmartphoneDownloadAppController {
	@GetMapping(value="/downloadSmartphoneApp")
	public String home( )  {
		return "smartphone_app";
    }
}
