package ru.kors.annotations;

public class UserNotFoundException extends Throwable{
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
