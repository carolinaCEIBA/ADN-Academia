package com.ceiba.aprendiz;

import com.ceiba.aprendiz.modelo.entidad.Aprendiz;

public class AprendizTestDataBuilder {
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

    public AprendizTestDataBuilder conAprendizPorDefecto(){
        this.id = 5l;
        this.nombre = "Carolina";
        this.apellido = "Fonseca";
        this.tipodoc = "CC";
        this.documento = "1000791524";
        this.eps = "Sanitas";
        this.categoria = "C1";
        this.valorcurso = 1500000.0;
        this.abono = 1500000.0;
        this.adicional = 70000.0;
        return this;
    }

    public AprendizTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public AprendizTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public AprendizTestDataBuilder conApellido(String apellido){
        this.apellido = apellido;
        return this;
    }

    public AprendizTestDataBuilder conTipoDoc(String tipodoc){
        this.tipodoc = tipodoc;
        return this;
    }

    public AprendizTestDataBuilder conDocumento(String documento){
        this.documento = documento;
        return this;
    }

    public AprendizTestDataBuilder conEps(String eps){
        this.eps = eps;
        return this;
    }

    public AprendizTestDataBuilder conCategoria(String categoria){
        this.categoria = categoria;
        return this;
    }

    public AprendizTestDataBuilder conValorCurso(double valorcurso){
        this.valorcurso = valorcurso;
        return this;
    }

    public AprendizTestDataBuilder conAbono(double abono){
        this.abono = abono;
        return this;
    }
    public AprendizTestDataBuilder conAdicional(double adicional){
        this.adicional = adicional;
        return this;
    }

    public Aprendiz crear() {
        return Aprendiz.crear(new SolicitudRegistrarApTestDataBuilder()
                .conId(id)
                .conNombre(nombre)
                .conApellido(apellido)
                .conTipoDoc(tipodoc)
                .conDocumento(documento)
                .conEps(eps)
                .conCategoria(categoria)
                .conValorCurso(valorcurso)
                .conAbono(abono)
                .conAdicional(adicional).build());
    }

    public Aprendiz reconstruir() {
        return Aprendiz.reconstruir(id, nombre, apellido, tipodoc, documento, eps, categoria, valorcurso, abono, adicional);
    }
}
