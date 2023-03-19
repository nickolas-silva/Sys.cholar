package br.edu.ufersa.sys_scholar.api.exception;

public class UserRegistredException extends RuntimeException {

    private static String message = "O usuário já está registrado no sistema!";

    public UserRegistredException() {
        super(message);
    }

    public UserRegistredException(String entity, Throwable cause) {
        super(message, cause);
    }
}
