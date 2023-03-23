package br.edu.ufersa.sys_scholar.api.exception;

public class InvalidIdentifierException extends RuntimeException {

    private static final String message = "Identificador de usuário (id) inválido!";

    public InvalidIdentifierException() {
        super(message);
    }

    public InvalidIdentifierException(Throwable cause) {
        super(message, cause);
    }

}
