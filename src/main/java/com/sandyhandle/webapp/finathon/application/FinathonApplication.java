package com.sandyhandle.webapp.finathon.application;

import com.sandyhandle.webapp.finathon.application.entity.AppUser;
import com.sandyhandle.webapp.finathon.application.entity.UserRole;
import com.sandyhandle.webapp.finathon.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class FinathonApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(FinathonApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		AppUser adminAccount = userRepository.findByRole(UserRole.ADMIN);

		AppUser user = new AppUser();

		user.setName("admin");
		user.setEmail("admin@gmail.com");
		user.setRole(UserRole.ADMIN);
		user.setPassword(passwordEncoder.encode("admin"));

		userRepository.save(user);

	}

}
