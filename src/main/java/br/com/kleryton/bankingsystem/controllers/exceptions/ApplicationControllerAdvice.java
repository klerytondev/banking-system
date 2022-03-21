package br.com.kleryton.bankingsystem.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.kleryton.bankingsystem.services.exceptions.ConflictDeDadosException;
import br.com.kleryton.bankingsystem.services.exceptions.IntegridadeDeDadosException;
import br.com.kleryton.bankingsystem.services.exceptions.ObjetoNaoEncontradoException;

@ControllerAdvice
public class ApplicationControllerAdvice {

	/*
	 *  Handler para tratar Status 404, caso o servidor não encontre uma representação atual do recurso solicitado
	 */
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjetoNaoEncontradoException e, HttpServletRequest request) {
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
	@ExceptionHandler(IntegridadeDeDadosException.class)
	public ResponseEntity<StandarError> dataIntegrity(IntegridadeDeDadosException e, HttpServletRequest request) {
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
	 * Handler para tratar Status 409, caso a solicitação não pôde ser concluída devido a um 
	 * conflito com o estado atual do recurso de destino
	 */
	@ExceptionHandler(ConflictDeDadosException.class)
	public ResponseEntity<StandarError> dataIntegrity(ConflictDeDadosException e, HttpServletRequest request) {
		StandarError err = new StandarError();
		HttpStatus status = HttpStatus.CONFLICT;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("A solicitação não pôde ser concluída devido a um conflito com o estado atual do recurso de destino!");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}