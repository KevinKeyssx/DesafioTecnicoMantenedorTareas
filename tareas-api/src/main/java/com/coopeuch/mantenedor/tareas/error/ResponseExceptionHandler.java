package com.coopeuch.mantenedor.tareas.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Kevin Candia
 * 17-01-2022
 */
@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllModelExcepcion(Exception ex, WebRequest request){
		return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleModelExcepcion(NotFoundException ex, WebRequest request){
		return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UnauthorizedException.class)
	public final ResponseEntity<ExceptionResponse> handleUnauthorizedModelExcepcion(UnauthorizedException ex, WebRequest request){
		return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(ExpectationFailedException.class)
	public final ResponseEntity<ExceptionResponse> handleExpectationFailedModelExcepcion(ExpectationFailedException ex, WebRequest request){
		return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)), HttpStatus.EXPECTATION_FAILED);
	}

	@Override
	public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)), HttpStatus.BAD_REQUEST);
	}

}