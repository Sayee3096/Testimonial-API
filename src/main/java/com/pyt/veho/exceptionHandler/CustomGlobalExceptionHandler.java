package com.pyt.veho.exceptionHandler;

/*
 * FileName: CustomGlobalExceptionHandler.java
 * 
 * Functionality: This class is used to override all the Exception methods that arises within the Spring 
 * Boot application. Currently, the MethodArgumentNotValidException is handled in this class. 
 * 
 */
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
  
   @Override
   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                 HttpHeaders headers,
                                                                 HttpStatus status, WebRequest request) {
       Map<String, Object> body = new LinkedHashMap<>();
       body.put("timestamp", new Date());
       body.put("status", status.value());
       List<String> errors = ex.getBindingResult()
               .getFieldErrors()
               .stream()
               .map(x -> x.getDefaultMessage())
               .collect(Collectors.toList());
       body.put("errors", errors);
       return new ResponseEntity<>(body, headers, status);
   }
}