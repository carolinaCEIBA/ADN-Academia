package com.ceiba.excepciones;

public class ExcepcionInstructor extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionInstructor(String message) {
        super(message);
    }
}
