package com.ceiba.excepciones;

public class ExcepcionPago extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionPago(String message) {
        super(message);
    }
}
