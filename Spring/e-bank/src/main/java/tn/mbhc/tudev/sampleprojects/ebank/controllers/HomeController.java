package tn.mbhc.tudev.sampleprojects.ebank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/index")
	public String index() {
		return "Welcome to E-Bank";
	}
	
}
