package com.samfresh09.resttemplatedemo.controllers;

import com.samfresh09.resttemplatedemo.entities.Todo;
import com.samfresh09.resttemplatedemo.services.interfaces.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TodoController {
    TodoService todoService;

    //use exchange to get all
    @GetMapping("/todo")
    public ResponseEntity<Todo[]> getAllTodo() {
        return  this.todoService.getAllTodo();
    }

    //use getForObject
    @GetMapping("/todo-for-object")
    public Todo getOneTodo(@RequestParam int id) {
        return  this.todoService.getOneTodo(id);
    }

    // use getForEntity
    @GetMapping("/todo-for-entity")
    public ResponseEntity<Todo> oneTodo(@RequestParam int id) {
        return  new ResponseEntity<>(this.todoService.oneTodo(id), HttpStatus.OK);
    }
}
