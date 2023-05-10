package lk.creativelabs.jobseekers;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class JobseekersApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobseekersApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return  new ModelMapper();
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
