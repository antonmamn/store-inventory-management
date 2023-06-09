package management.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleConflict(
            Exception ex, WebRequest request) {
                    return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
