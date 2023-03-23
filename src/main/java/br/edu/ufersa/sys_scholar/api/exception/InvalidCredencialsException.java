package br.edu.ufersa.sys_scholar.api.exception;

public class InvalidCredencialsException extends RuntimeException {

    private static String message = " inválida!";

    public InvalidCredencialsException(String entity) {
        super(entity.concat(message));
    }

    public InvalidCredencialsException(String entity, Throwable cause) {
        super(entity.concat(message), cause);
    }
}
