package tn.mbhc.tudev.spring.rest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


// The app class is not in the base backage 
@ComponentScan(basePackages = "tn.mbhc.tudev")
@SpringBootApplication
public class HelloWorldRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldRestServiceApplication.class, args);
	}

}
