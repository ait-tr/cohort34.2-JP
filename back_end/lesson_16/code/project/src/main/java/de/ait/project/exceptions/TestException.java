package de.ait.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
public class TestException extends GeneralUnCheckedException{
    public TestException(String msg) {
        super(msg);
    }
}
