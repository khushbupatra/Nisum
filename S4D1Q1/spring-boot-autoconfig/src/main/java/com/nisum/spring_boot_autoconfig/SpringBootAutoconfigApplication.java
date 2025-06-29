package com.nisum.spring_boot_autoconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootAutoconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAutoconfigApplication.class, args);
	}

	@RestController
	static class GreeterController {
		private final Greeter greeter;

		public GreeterController(Greeter greeter) {
			this.greeter = greeter;
		}

		@GetMapping("/")
		public String greet() {
			return greeter.greet();
		}
	}
}