package com.ceiba.excepciones;

public class ExcepcionTeoria extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionTeoria(String message) {
        super(message);
    }
}
