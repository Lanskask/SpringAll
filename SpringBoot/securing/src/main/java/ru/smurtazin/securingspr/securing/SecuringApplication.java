package ru.smurtazin.securingspr.securing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecuringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuringApplication.class, args);
	}
}
