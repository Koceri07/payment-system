package springboot.paymentsystem.paymentsystem.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(NotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("NOT_FOUND");
        errorResponse.setMessage(exception.getMessage());
        return ResponseEntity.status(404).body(errorResponse);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ErrorResponse> handle(InsufficientBalanceException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("INSUFFICIENT_BALANCE");
        errorResponse.setMessage(exception.getMessage());
        return ResponseEntity.status(400).body(errorResponse);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorResponse> handle(ForbiddenException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("FORBIDDEN");
        errorResponse.setMessage(exception.getMessage());
        return ResponseEntity.status(403).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("VALIDATION_ERROR");
        errorResponse.setMessage(exception.getBindingResult().getFieldError().getDefaultMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handle(HttpRequestMethodNotSupportedException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("METHOD_NOT_SUPPORTED");
        errorResponse.setMessage(exception.getMessage());
        return ResponseEntity.status(405).body(errorResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handle(HttpMessageNotReadableException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("BAD_REQUEST");
        errorResponse.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorResponse> handle(MissingRequestHeaderException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("MISSING_HEADER");
        errorResponse.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handle(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("INTERNAL_SERVER_ERROR");
        errorResponse.setMessage("An unexpected error occurred");
        return ResponseEntity.status(500).body(errorResponse);
    }
}
