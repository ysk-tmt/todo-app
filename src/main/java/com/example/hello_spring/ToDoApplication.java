package com.example.hello_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}

	private final TodoRepository todoRepository;
	
	public ToDoApplication(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	@Bean
	public CommandLineRunner demoCommandLineRunner() {
		return args ->{
//			todoRepository.save(new Todo("勉強"));
		};
	}
}
