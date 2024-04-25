package de.ait.project.user.controller;

import de.ait.project.advertisement.dto.AdvertisementRequestDto;
import de.ait.project.exceptions.ApiError;
import de.ait.project.exceptions.TestException;
import de.ait.project.exceptions.UserNotFoundException;
import de.ait.project.user.dto.UserRequestDto;
import de.ait.project.user.dto.UserResponseDto;
import de.ait.project.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getAuthorById(@PathVariable  Long id){
        if (id<0) throw new TestException("test exception");
         return ResponseEntity.ok(userService.findById(id));
    }


    @PostMapping
    //@ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<UserResponseDto> createNewUser(@RequestBody @Valid UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.save(userRequestDto),HttpStatus.CREATED) ;
    }

    // POST  /api/authors/{userId}/advertisements/
    @PostMapping("/{userId}/advertisements/")
    public UserResponseDto addAdvertisementsToUser(@PathVariable Long userId, @RequestBody AdvertisementRequestDto advertisementRequestDto){
        return  userService.addAdvertisement(userId,advertisementRequestDto);
    }




}
