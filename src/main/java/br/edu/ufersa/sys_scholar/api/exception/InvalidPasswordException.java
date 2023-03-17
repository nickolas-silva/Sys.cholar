package br.edu.ufersa.sys_scholar.api.exception;

public class InvalidPasswordException extends RuntimeException {

    private static String message = " Senha Inválida!";

    public InvalidPasswordException() {
        super(message);
    }

    public InvalidPasswordException(Throwable cause) {
        super(message, cause);
    }
}
