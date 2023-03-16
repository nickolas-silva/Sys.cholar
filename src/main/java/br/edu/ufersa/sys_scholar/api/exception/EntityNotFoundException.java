package br.edu.ufersa.sys_scholar.api.exception;

public class EntityNotFoundException extends RuntimeException {

    private static String message = " não encontrado!";

    public EntityNotFoundException(String entity) {
        super(message + entity);
    }

    public EntityNotFoundException(String entity, Throwable cause) {
        super(message + entity, cause);
    }
}
