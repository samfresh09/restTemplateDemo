package com.samfresh09.resttemplatedemo.services.interfaces;

import com.samfresh09.resttemplatedemo.entities.Todo;
import org.springframework.http.ResponseEntity;

public interface TodoService {
    Todo getOneTodo(int id);
    Todo oneTodo(int id);
    ResponseEntity<Todo[]> getAllTodo();
}
