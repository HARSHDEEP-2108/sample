package com.example.harsh.to_dolist.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import jakarta.validation.Valid;

@Component
public class Todo_service {
	

		private static int count=0;
		private static List<Todo> todos=new ArrayList<>();
		static {
			todos.add(new Todo(++count,"Harsh","AWS",LocalDate.now().plusYears(1),false));
			todos.add(new Todo(++count,"Harsh","Java",LocalDate.now().plusYears(2),false));
		}
		
		public List<Todo> findByUsername(String name){
			Predicate<? super Todo> predicate = todo->todo.getUsername().equalsIgnoreCase(name);
			return todos.stream().filter(predicate).toList();
		}
		
		public void add_todo(String username,String description,LocalDate targetDate) {
			Todo todo=new Todo(++count,username,description,targetDate,false);
			todos.add(todo);
		}
		
		
		public void deleteTodoById(int id) {
			
			Predicate<? super Todo> predicate = todo->todo.getId()==id;
			todos.removeIf(predicate);
		}
		
		
		public Todo findById(int id) {
			// TODO Auto-generated method stub
			Predicate<? super Todo> predicate = todo->todo.getId()==id;
			return todos.stream().filter(predicate).findFirst().get();
		}

		
		public void update_todo(@Valid Todo todo) {
			// TODO Auto-generated method stub
			deleteTodoById(todo.getId());
			todos.add(todo);
		}
		
}
