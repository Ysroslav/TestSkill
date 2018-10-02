package ru.bodrov.enterprise.TryForStaff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TryForStaffApplication {

	public static void main(String[] args) {
		SpringApplication.run(TryForStaffApplication.class, args);
	}

    @GetMapping("/")
	public String hello(){
		return "HELLO WORLD";
	}
}
