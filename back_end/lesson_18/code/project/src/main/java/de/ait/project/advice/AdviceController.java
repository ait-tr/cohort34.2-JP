package de.ait.project.advice;

import de.ait.project.exceptions.ApiError;
import de.ait.project.exceptions.UserNotFoundException;
import de.ait.project.exceptions.ValidationError;
import de.ait.project.exceptions.ValidationErrorsResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(value={UserNotFoundException.class})
    public ResponseEntity<ApiError> userNotFoundHandler(UserNotFoundException ex){
        System.out.println("!!! Exception " + ex.getMessage());
        return new ResponseEntity<>(new ApiError(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    //MethodArgumentNotValidException
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ValidationErrorsResponse> validationErrorHandler(MethodArgumentNotValidException ex,
                                                                           HttpServletRequest request){

        List<ValidationError> list = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(objectError -> (FieldError) objectError)
                .map(ValidationError::of)
                .toList();

        ValidationErrorsResponse response = new ValidationErrorsResponse(
                HttpStatus.BAD_REQUEST,
                "Validation error",
                request.getServletPath(),
                list
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}
