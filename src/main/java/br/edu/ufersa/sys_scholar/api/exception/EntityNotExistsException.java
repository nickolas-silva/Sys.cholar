package br.edu.ufersa.sys_scholar.api.exception;

public class EntityNotExistsException extends RuntimeException {

    private static String message = " não encontrado!";

    public EntityNotExistsException(String entity) {
        super(entity.concat(message));
    }

    public EntityNotExistsException(String entity, Throwable cause) {
        super(entity.concat(message), cause);
    }
}
