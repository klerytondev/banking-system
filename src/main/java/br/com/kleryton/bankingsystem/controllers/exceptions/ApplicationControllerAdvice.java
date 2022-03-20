package br.com.kleryton.bankingsystem.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import javassist.tools.rmi.ObjectNotFoundException;

@ControllerAdvice
public class ApplicationControllerAdvice {

	// Handler para tratar Status 404, caso algum atributo não seja passado no corpo
	// do Json
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandarError err = new StandarError();
		HttpStatus status = HttpStatus.NOT_FOUND;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Não foi possível encontrar o recurso solicitado!");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	/*
	 * Handler para tratar Status 400, caso algum atributo não seja passado no corpo
	 * do Json
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandarError> dataIntegrity(MethodArgumentNotValidException e, HttpServletRequest request) {
		StandarError err = new StandarError();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Integridade de dados!");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	/*
	 * Handler para tratar Status 500, caso servidor encontrou um condição
	 * inesperada que o impediu de atender completamente a requisição
	 */
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<StandarError> dataIntegrity(InternalServerError e, HttpServletRequest request) {
		StandarError err = new StandarError();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("O servidor encontrou uma condição inesperada!");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
