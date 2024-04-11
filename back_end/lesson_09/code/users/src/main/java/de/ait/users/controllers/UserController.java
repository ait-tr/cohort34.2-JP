package de.ait.users.controllers;

import de.ait.users.dto.UserRequestDTO;
import de.ait.users.model.User;
import de.ait.users.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Tags(value = {
        @Tag(name="Пользователи", description = "Операции с пользователями"),
        @Tag(name="Users", description = "Users operation")
})


public class UserController {
    private final UserService service;


    @Operation( summary = "Получение списка пользователей",
                description = "Список всех пользоваьелей. Доступно администратору")
    //@GetMapping("/users")
    // localhost:8080/users?age=10

    @GetMapping
    public List<UserRequestDTO> getAllUsers(@RequestParam(required = false, defaultValue = "0") int age,
                                            @RequestParam(required = false) String name){
        System.out.println(name);
        return service.findAll(age);
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
