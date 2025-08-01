package com.example.hello_spring;

import java.util.List;
import java.util.NoSuchElementException;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoController {
	private final TodoRepository todoRepository;
	public ToDoController(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	@GetMapping("/todos")
	public String showTodo(Model model) {
		List<Todo> todoList = todoRepository.findByComp(false);
		model.addAttribute("todoList", todoList);
		return "todo";
	}
	
	@PostMapping("/todo/add")
	public String addTodo(
			@Valid Todo todo,
			BindingResult bindingResult,
			Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("todoList", todo);
			return "todo";
		}
		todoRepository.save(todo);
		return "redirect:/todos";
	}

	@GetMapping("/todo/{id}/edit")
	public String editTodo(@PathVariable("id") Long id, Model model) {
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("ID: " + id + " のToDoが見つかりません。")); ;
		model.addAttribute("todo", todo);
		return "todo_edit";
	}
	
	@PostMapping("/todo/update")
	public String updateTodo(@Valid Todo todo, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("todoList", todo);
			return "todo_edit";
		}
		todoRepository.save(todo);
		return "redirect:/todos";
	}
	
	@PostMapping("/todo/{id}/delete")
	public String deleteTodo(@PathVariable("id") Long id) {
		todoRepository.deleteById(id);
		return "redirect:/todos";
	}
	
	@GetMapping("/todo_complete")
	public String showCompleteTodo(Model model) {
		List<Todo> todoList = todoRepository.findByComp(true);
		model.addAttribute("todoList", todoList);
		return "complete";
	}
	
	@PostMapping("/todo/{id}/complete")
	public String completeTodo(@PathVariable("id") Long id) {
		Todo comp = todoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("ID: " + id + " のToDoが見つかりません。"));;
		comp.setComp(true);
		todoRepository.save(comp);
		return "redirect:/todos";
	}
	
	@PostMapping("/todo/{id}/false")
	public String incompleteTodo(@PathVariable("id") Long id) {
		Todo comp = todoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("ID: " + id + " のToDoが見つかりません。"));;
		comp.setComp(false);
		todoRepository.save(comp);
		return "redirect:/todo_complete";
	}
}