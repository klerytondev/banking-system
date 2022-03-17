package br.com.kleryton.bankingsystem.exceptions;

import java.util.Arrays;
import java.util.List;

//Mostra os possíveis erros na hora das requisições
public class ApiErrors {

	private List<String> errors;

	public ApiErrors(List<String> errors) {
		this.errors = errors;
	}

	public ApiErrors(String message) {
		this.errors = Arrays.asList(message);
	}

	public List<String> getErrors() {
		return errors;
	}

}