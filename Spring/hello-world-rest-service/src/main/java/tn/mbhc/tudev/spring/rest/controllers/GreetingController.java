package tn.mbhc.tudev.spring.rest.controllers;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.mbhc.tudev.spring.rest.data.Greeting;
import tn.mbhc.tudev.spring.rest.utils.DateTimeUtils;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Spring user") String name) {
		return new Greeting(
				counter.incrementAndGet(), 
				String.format(template, name),
				DateTimeUtils.format(LocalDate.now())
			);
	}
	
}
