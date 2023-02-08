package com.codeburps.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int userId) {
        super("User not found: " + userId);
    }
}
