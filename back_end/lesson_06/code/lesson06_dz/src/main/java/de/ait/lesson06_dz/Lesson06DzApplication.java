package de.ait.lesson06_dz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lesson06DzApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Lesson06DzApplication.class, args);
		System.out.println("hello");
	}

}
