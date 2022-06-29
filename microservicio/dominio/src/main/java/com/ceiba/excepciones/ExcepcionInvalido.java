package com.ceiba.excepciones;

public class ExcepcionInvalido extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionInvalido(String message) {
        super(message);
    }
}
