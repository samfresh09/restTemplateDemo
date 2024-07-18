package com.samfresh09.resttemplatedemo.services.impl;

import com.samfresh09.resttemplatedemo.entities.Todo;
import com.samfresh09.resttemplatedemo.services.interfaces.TodoService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TodoServiceImp implements TodoService {

    public static final String URL = "https://jsonplaceholder.typicode.com/posts/";
    RestTemplate restTemplate= new RestTemplate();

    // GET OPERATION
    HttpHeaders headers = new HttpHeaders();

    HttpEntity httpEntity= new HttpEntity(headers);

    //recuperation de tous les todos avec exchange
    public ResponseEntity<Todo[]> getAllTodo() {
        return this.restTemplate.exchange(URL, HttpMethod.GET,httpEntity, Todo[].class);
    }

    //recuperation d'un todos avec getForObject
    @Override
    public Todo getOneTodo(int id) {
        return this.restTemplate.getForObject(URL+id , Todo.class);
    }

    //recuperation d'un todos avec getForEntity
    @Override
    public Todo oneTodo(int id) {
        return this.restTemplate.getForEntity(URL+id , Todo.class).getBody();
    }

    // POST OPERATION

    //add with postForObject method
    @Override
    public Todo addTodoOne(Todo todo) {

        System.out.println("todo: "+todo.getBody());
        return this.restTemplate.postForObject(URL, todo, Todo.class);
    }

    //add with postForEntity method
    @Override
    public Todo addTodoTwo(Todo todo) {
        return this.restTemplate.postForEntity(URL, todo, Todo.class).getBody();
    }




}
