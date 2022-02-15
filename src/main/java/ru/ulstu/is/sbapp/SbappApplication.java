package ru.ulstu.is.sbapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SbappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbappApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/kvadrat")
	public String kvadrat(@RequestParam(value = "num", defaultValue = "10") int num) {
		return String.format("Квадрат: %s", num * num);
	}

	@GetMapping("/koren")
	public String koren(@RequestParam(value = "num", defaultValue = "100") int num) {
		return String.format("Корень: %s", Math.sqrt(num));
	}

}
