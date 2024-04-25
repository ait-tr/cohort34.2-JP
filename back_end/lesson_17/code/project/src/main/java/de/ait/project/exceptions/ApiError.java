package de.ait.project.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {
    private String msg;
    private int statusCode;
    private HttpStatus status;

    public ApiError(String msg, HttpStatus status) {
        this.msg = msg;
        this.status = status;
        this.statusCode = status.value();
    }
}
