// package com.example.demo.exception;

// import com.example.demo.dto.ApiErrorResponse;
// import jakarta.persistence.EntityNotFoundException;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(EntityNotFoundException.class)
//     public ResponseEntity<ApiErrorResponse> handleEntityNotFound(EntityNotFoundException ex) {
//         ApiErrorResponse error = new ApiErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
//     }

//     @ExceptionHandler(IllegalArgumentException.class)
//     public ResponseEntity<ApiErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
//         ApiErrorResponse error = new ApiErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
//         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//     }

//     @ExceptionHandler(ValidationException.class)
//     public ResponseEntity<ApiErrorResponse> handleValidation(ValidationException ex) {
//         ApiErrorResponse error = new ApiErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
//         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//     }
// }