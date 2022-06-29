package com.ceiba.aprendiz.controlador;

import com.ceiba.factura.comando.ComandoSolicitudRegistrarAp;

public class ComandoAprendizTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellido;
    private String tipodoc;
    private String documento;
    private String eps;
    private String categoria;
    private double valorcurso;
    private double abono;

    private double adicional;

    public ComandoAprendizTestDataBuilder aprendizPorDefecto(){
        this.id = 6l;
        this.nombre = "Carolina";
        this.apellido = "Fonseca";
        this.tipodoc = "CC";
        this.documento = "1000791524";
        this.eps = "Sanitas";
        this.categoria = "C1";
        this.valorcurso = 1500000;
        this.abono = 1500000;
        this.adicional = 70000;
        return this;
    }

    public ComandoSolicitudRegistrarAp build() {
        return new ComandoSolicitudRegistrarAp(this.id, this.nombre, this.apellido, this.tipodoc, this.documento, this.eps, this.categoria, this.valorcurso, this.abono, this.adicional);
    }
}
