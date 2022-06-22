package com.ceiba.programacion.controlador;


import com.ceiba.programacion.modelo.entidad.Programacion;

public class RespuestaFacturar {
    private Long valor;

    public RespuestaFacturar() {
    }

    public RespuestaFacturar(Long valor) {
        this.valor = valor;
    }

    public Programacion getValor() {
        return valor;
    }
}
