package de.ait.project.user.controller;

import de.ait.project.advertisement.dto.AdvertisementRequestDto;
import de.ait.project.exceptions.ApiError;
import de.ait.project.exceptions.TestException;
import de.ait.project.exceptions.UserNotFoundException;
import de.ait.project.user.dto.UserRequestDto;
import de.ait.project.user.dto.UserResponseDto;
import de.ait.project.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
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

@Tags(@Tag(name="Users", description = "Users handling Api"))
public class UserController {
    private final UserService userService;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                         description = "Return list of all users",
                         content = @Content(mediaType = "application/json",
                         schema =@Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "500",description = "Server Internal error")
    })
    @Operation(summary ="get all users", description = "Available for users with  administrator role")
    @GetMapping
    public List<UserResponseDto> getAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getAuthorById(@PathVariable  Long id){
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
