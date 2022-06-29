package com.ceiba.excepciones;

public class ExcepcionFecha extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionFecha(String message) {
        super(message);
    }
}
