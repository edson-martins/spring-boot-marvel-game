package br.com.martins.edson.spring.marvel.game.exception.rest.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.martins.edson.spring.marvel.game.exception.model.ExceptionDetail;

/**
* Class      : RestExceptionHandler
* Superclass : ResponseEntityExceptionHandler
* Description: Exception handler to intercept the controller exception raised.
*
* @author Edson Martins
*/
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<>(
				ExceptionDetail.builder()
							   .timestamp(LocalDateTime.now())
							   .status(HttpStatus.BAD_REQUEST.value()).title("Invalid field(s). "
							   		+ "If you are using the Game service, check the seed value, because must be between 1-10.")
							   .details(ex.getMessage()).developerMessage(ex.getClass().getName())
							   .build(), HttpStatus.BAD_REQUEST);
	}
}
