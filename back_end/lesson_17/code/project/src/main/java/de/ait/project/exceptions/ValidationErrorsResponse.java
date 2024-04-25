package de.ait.project.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorsResponse {
    private Date timestamp;
    private HttpStatus status;
    private int statusCode;
    private String message;
    private String url;
    private List<ValidationError> validationErrors;

    public ValidationErrorsResponse(HttpStatus status, String message, String url, List<ValidationError> validationErrors) {
        this.status = status;
        this.message = message;
        this.url = url;
        this.validationErrors = validationErrors;
        this.statusCode = status.value();
        this.timestamp = new Date();
    }
}
