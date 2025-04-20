package com.bsl.business;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bsl.business.entities.ROLE;
import com.bsl.business.entities.User;
import com.bsl.business.repository.UserRepository;

@SpringBootApplication
public class BusinessApplication implements CommandLineRunner	{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User UeradminAccount = userRepository.findByRole(ROLE.ADMIN);
		if(ObjectUtils.isEmpty(UeradminAccount)) {
			User user = new User();
			user.setFirstName("admin");
			user.setSecondName("admin");
			user.setEmail("admin@gmail.com");
			user.setRole(ROLE.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}

}
