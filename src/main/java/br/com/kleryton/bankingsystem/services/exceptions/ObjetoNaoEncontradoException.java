package br.com.kleryton.bankingsystem.services.exceptions;

/*
 *  Handler para tratar Status 404, caso o servidor não encontre uma representação atual do recurso solicitado
 */

public class ObjetoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ObjetoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
