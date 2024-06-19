package tn.mbhc.tudev.sampleprojects.ebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestEBankApplication {

	public static void main(String[] args) {
		SpringApplication.from(EBankApplication::main).with(TestEBankApplication.class).run(args);
	}

}
