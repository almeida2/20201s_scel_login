package com.fatec.scel;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//https://medium.com/@nataniel.paiva/oauth2-com-spring-boot-2-e-spring-5-e7bfb7c58d4a
//https://spring.io/guides/tutorials/spring-boot-oauth2/

@SpringBootApplication
@RestController
public class ScelApplication {
	 @GetMapping("/user")
	    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
	        return Collections.singletonMap("name", principal.getAttribute("name"));
	    }
	public static void main(String[] args) {
		SpringApplication.run(ScelApplication.class, args);
	}

}
