package br.com.ricardo.springboot.services.exceptions;

public class ObjetctNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1l;

    public ObjetctNotFoundException(String msg) {
        super(msg);

    }

    public ObjetctNotFoundException(String msg, Throwable cause) {
        super(msg, cause);

    }
}
