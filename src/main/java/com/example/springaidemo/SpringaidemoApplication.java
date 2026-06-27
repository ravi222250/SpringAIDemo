package com.example.springaidemo;

import com.example.springaidemo.service.ChatClientService;
import org.jspecify.annotations.NullMarked;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NullMarked
public class SpringaidemoApplication implements CommandLineRunner {

	private final ChatClientService openAIChatClientService;
	private final ChatClientService genAIChatClientService;

	public SpringaidemoApplication(
			@Qualifier("openAIChatClientService") ChatClientService openAIChatClientService,
			@Qualifier("genAIChatClientService") ChatClientService genAIChatClientService) {
		this.openAIChatClientService = openAIChatClientService;
		this.genAIChatClientService = genAIChatClientService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringaidemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("***************************************");
		System.out.println(genAIChatClientService.chat("What is Bangalore, India famous for?"));
		System.out.println("***************************************");
	}
}
