package ru.mineeva.app.exeption;

public class ValidationFailedException extends RuntimeException {

    private static final String MESSAGE = "Validation Failed";

    public ValidationFailedException() {
        super(MESSAGE);
    }
}
