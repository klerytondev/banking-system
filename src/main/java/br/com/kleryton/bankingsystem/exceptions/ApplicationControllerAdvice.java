package br.com.kleryton.bankingsystem.exceptions;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ApiErrors ErrosDeValidacao(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		List<String> messages = bindingResult.getAllErrors().stream()
				.map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
		return new ApiErrors(messages);
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandartError> StatusError(DataIntegrityViolationException e, HttpServletRequest request){
		StandartError err = new StandartError();
		HttpStatus status = HttpStatus.CONFLICT;
		err.setTimestamp(Instant.now());;
		err.setStatus(status.value());
		err.setError("Error: Duplicate entry");
		err.setMessage("Numero da conta em uso!");
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	public ResponseEntity<ErroPadrao> StatusError(HttpMessageNotReadableException e, HttpServletRequest request){
//		HttpStatus status = HttpStatus.CONFLICT;
//		ErroPadrao err = new ErroPadrao();
//		err.setTimeStamp(Instant.now());
//		err.setStatus(status.value());
//		err.setError("Erro Status Invalido");
//		err.setMessage("Valores aceitos: [ATIVO, INATIVO]");
//		err.setPath(request.getRequestURI());
//		
//		return ResponseEntity.status(status).body(err);
	
}
