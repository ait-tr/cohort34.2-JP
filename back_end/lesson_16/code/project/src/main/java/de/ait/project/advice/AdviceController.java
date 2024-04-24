package de.ait.project.advice;

import de.ait.project.exceptions.ApiError;
import de.ait.project.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(value={UserNotFoundException.class})
    public ResponseEntity<ApiError> userNotFoundHandler(UserNotFoundException ex){
        System.out.println("!!! Exception " + ex.getMessage());
        return new ResponseEntity<>(new ApiError(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

}
