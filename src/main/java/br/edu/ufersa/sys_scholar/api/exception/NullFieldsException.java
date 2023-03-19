package br.edu.ufersa.sys_scholar.api.exception;

public class NullFieldsException extends RuntimeException {
    private static final String message = "Um ou mais campos estão vazios!";

    public NullFieldsException() {
        super(message);
    }

    public NullFieldsException(Throwable cause) {
        super(message, cause);
    }
}