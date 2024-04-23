package de.ait.project.user.controller;

import de.ait.project.advertisement.dto.AdvertisementRequestDto;
import de.ait.project.user.dto.UserRequestDto;
import de.ait.project.user.dto.UserResponseDto;
import de.ait.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAll(){
        return userService.findAll();
    }
    @PostMapping
    public UserResponseDto createNewUser(@RequestBody UserRequestDto userRequestDto){
        return userService.save(userRequestDto);
    }

    // POST  /api/authors/{userId}/advertisements/
    @PostMapping("/{userId}/advertisements/")
    public UserResponseDto addAdvertisementsToUser(@PathVariable Long userId, @RequestBody AdvertisementRequestDto advertisementRequestDto){
        return  userService.addAdvertisement(userId,advertisementRequestDto);
    }


}
