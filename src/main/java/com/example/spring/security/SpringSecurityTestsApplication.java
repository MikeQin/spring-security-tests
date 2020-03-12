package com.example.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@RestController
public class SpringSecurityTestsApplication {
	
	@GetMapping("/get")
	public ResponseEntity<String> get() {
		return ResponseEntity.ok("Get OK");
	}

	@PostMapping("/post")
	public ResponseEntity<String> post() {
		return ResponseEntity.ok("Post OK");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityTestsApplication.class, args);
	}

}
