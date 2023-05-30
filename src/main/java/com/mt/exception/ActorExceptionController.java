package com.mt.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ActorExceptionController {

	@ExceptionHandler(ActorNotFoundException.class)
	public ResponseEntity<ErrorsMessages> IdNotFoundMethod(ActorNotFoundException ex){
		ErrorsMessages error=new ErrorsMessages(LocalDateTime.now(),ex.getMessage(),"404-Actor not found.");
		return new ResponseEntity<ErrorsMessages>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorsMessages> genericExceptionMethod(Exception ex){
		ErrorsMessages error=new ErrorsMessages(LocalDateTime.now(),ex.getMessage(),"404-Actor not found.");
		return new ResponseEntity<ErrorsMessages>(error,HttpStatus.NOT_FOUND);
	}
}
