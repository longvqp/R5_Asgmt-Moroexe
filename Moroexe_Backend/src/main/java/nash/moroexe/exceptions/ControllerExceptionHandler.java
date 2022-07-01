package nash.moroexe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionMessage> resourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        ExceptionMessage message = new ExceptionMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ExceptionMessage>(message, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionMessage> globalExceptionHandler(Exception exception, WebRequest request) {
        ExceptionMessage message = new ExceptionMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ExceptionMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
