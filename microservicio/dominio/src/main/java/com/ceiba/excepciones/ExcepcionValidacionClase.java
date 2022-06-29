package com.ceiba.excepciones;

public class ExcepcionValidacionClase extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionValidacionClase(String message) {
        super(message);
    }
}
