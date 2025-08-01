package com.example.hello_spring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	List<Todo> findByComp(boolean comp);
}
