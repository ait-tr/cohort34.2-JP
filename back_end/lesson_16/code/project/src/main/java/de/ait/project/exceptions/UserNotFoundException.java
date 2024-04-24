package de.ait.project.exceptions;

public class UserNotFoundException extends GeneralUnCheckedException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
