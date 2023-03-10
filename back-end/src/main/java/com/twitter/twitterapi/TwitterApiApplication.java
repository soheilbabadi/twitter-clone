package com.twitter.twitterapi;

import com.twitter.twitterapi.model.Role;
import com.twitter.twitterapi.reposotory.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TwitterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterApiApplication.class, args);
	}


//	@Bean
//	public CommandLineRunner run(RoleRepository roleRepository) {
//		return args -> {
//			var admin= Role.builder().authority("ROLE_ADMIN").build();
//			var user= Role.builder().authority("ROLE_USER").build();
//		roleRepository.save(admin);
//		roleRepository.save(user);
//
//
//		};
//	}
}
