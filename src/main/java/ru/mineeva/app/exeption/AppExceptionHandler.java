package ru.mineeva.app.exeption;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ValidationFailedException.class)
    protected ResponseEntity<Error> handleValidationFailed(ValidationFailedException ex) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        Error error = context.getBean("errorBean", Error.class);
//        Error error = new Error(400, ex.getMessage());
        context.close();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
