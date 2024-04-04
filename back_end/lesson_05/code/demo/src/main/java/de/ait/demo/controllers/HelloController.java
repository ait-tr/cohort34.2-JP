package de.ait.demo.controllers;

import de.ait.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello from server";
    }

    @GetMapping("/user")
    public User getUser(){
        return new User("Jack","wert@gmail.ru");
    }

}
