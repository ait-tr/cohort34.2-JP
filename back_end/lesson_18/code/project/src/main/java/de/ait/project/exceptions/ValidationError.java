package de.ait.project.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidationError {
    private String field;
    private String rejectedValue;
    private  String message;

    public static ValidationError of(FieldError fieldError){
        return ValidationError.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .rejectedValue( fieldError.getRejectedValue()!=null? fieldError.getRejectedValue().toString() : "" )
                    .build();
        }
}


