package com.example.harsh.to_dolist.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	public TodoControllerJpa(Todo_service todoservice,TodoRepository todoRepository) {
		super();
		this.todoservice = todoservice;
		this.todoRepository=todoRepository;
	}
	
	private TodoRepository todoRepository;
	private Todo_service todoservice;
	
	
	@RequestMapping("todo-list")
	public String ListTodos(ModelMap model) {
		String username=getLoggedInUsername(model);
		List<Todo>todos= todoRepository.findByUsername(username);
	
		model.addAttribute("todos",todos);
		return "todos";
	}
	
	
	@RequestMapping(value="addTodo", method=RequestMethod.GET)
	public String AddTodo(ModelMap model) {
		String username=getLoggedInUsername(model);
		Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}


	
	
	@RequestMapping(value="addTodo", method=RequestMethod.POST)
	public String BackToTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors())return "todo";
		
		String username=getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
//		todoservice.add_todo(username, todo.getDescription(),todo.getTargetDate());
		return "redirect:todo-list";
		
	}
	
	@RequestMapping(value="delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoRepository.deleteById(id);
		return "redirect:todo-list";
	} 
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdatePage(ModelMap model,@RequestParam int id) {
		Todo todo=todoRepository.findById(id).get();
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors())return "todo";
		
		String username=getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		
//		todoservice.update_todo(todo);
		return "redirect:todo-list";
		
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	
	
}
