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
    private Long inasistencia;
    private double valorcurso;
    private double adicional;
    private Long refuerzo;

    public ComandoAprendizTestDataBuilder aprendizPorDefecto(){
        this.id = 3l;
        this.nombre = "Carolina";
        this.apellido = "Fonseca";
        this.tipodoc = "CC";
        this.documento = "1000791524";
        this.eps = "Sanitas";
        this.categoria = "C1";
        this.inasistencia = 1l;
        this.valorcurso = 1450000;
        this.adicional = 0;
        this.refuerzo = 2l;
        return this;
    }

    public ComandoSolicitudRegistrarAp build() {
        return new ComandoSolicitudRegistrarAp(this.id, this.nombre, this.apellido, this.tipodoc, this.documento, this.eps, this.categoria, this.inasistencia, this.valorcurso, this.adicional, this.refuerzo);
    }
}
