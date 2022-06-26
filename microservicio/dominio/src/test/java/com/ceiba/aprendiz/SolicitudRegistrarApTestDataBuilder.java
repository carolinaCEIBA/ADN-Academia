package com.ceiba.aprendiz;

import com.ceiba.aprendiz.modelo.entidad.SolicitudRegistrarAp;

public class SolicitudRegistrarApTestDataBuilder {

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
    public SolicitudRegistrarApTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public SolicitudRegistrarApTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public SolicitudRegistrarApTestDataBuilder conApellido(String apellido){
        this.apellido = apellido;
        return this;
    }

    public SolicitudRegistrarApTestDataBuilder conTipoDoc(String tipodoc){
        this.tipodoc = tipodoc;
        return this;
    }

    public SolicitudRegistrarApTestDataBuilder conDocumento(String documento){
        this.documento = documento;
        return this;
    }

    public SolicitudRegistrarApTestDataBuilder conEps(String eps){
        this.eps = eps;
        return this;
    }

    public SolicitudRegistrarApTestDataBuilder conCategoria(String categoria){
        this.categoria = categoria;
        return this;
    }

    public SolicitudRegistrarApTestDataBuilder conValorCurso(double valorcurso){
        this.valorcurso = valorcurso;
        return this;
    }

    public SolicitudRegistrarApTestDataBuilder conAbono(double abono){
        this.abono = abono;
        return this;
    }
    public SolicitudRegistrarApTestDataBuilder conAdicional(double adicional){
        this.adicional = adicional;
        return this;
    }

    public SolicitudRegistrarAp build() {
        return new SolicitudRegistrarAp(id, nombre, apellido, tipodoc, documento, eps, categoria, valorcurso, abono, adicional);
    }
}
