package de.ait.users.controllers;

import de.ait.users.model.User;
import de.ait.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService service;


    //@GetMapping("/users")
    @GetMapping
    public List<User> getAllUsers(){
        return service.findAll();
    }

    //@GetMapping("/users/{id}")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return service.findById(id).get();
    }

    //@PostMapping("/users")
    @PostMapping
    public void addNewUser(@RequestBody User user){
        System.out.println(user);
        service.add(user);
    }

    //@DeleteMapping("/users/{id}")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable  Long id){
        service.deleteById(id);
    }

    //@PutMapping("/users/{id}")
    @PutMapping("/{id}")
    public void updateUserById(@PathVariable  Long id, @RequestBody User user){

    }

}
