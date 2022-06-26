package com.ceiba.aprendiz.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;

public class Aprendiz {
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


    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEps() {
        return eps;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getValorcurso() {
        return valorcurso;
    }

    public double getAbono() { return abono; }

    public double getAdicional() {
        return adicional;
    }

    public Aprendiz(Long id, String nombre, String apellido, String tipodoc, String documento, String eps, String categoria, double valorcurso, double abono, double adicional) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipodoc = tipodoc;
        this.documento = documento;
        this.eps = eps;
        this.categoria = categoria;
        this.valorcurso = valorcurso;
        this.abono = abono;
        this.adicional = adicional;

    }
    public static Aprendiz crear(SolicitudRegistrarAp solicitudRegistrarAp) {
        ValidadorArgumento.validarObligatorio(solicitudRegistrarAp.getNombre(), "El nombre del aprendiz es obligatorio para el registro");
        ValidadorArgumento.validarObligatorio(solicitudRegistrarAp.getDocumento(), "El ... del aprendiz es obligatorio para el registro");
        return new Aprendiz(solicitudRegistrarAp.getId(), solicitudRegistrarAp.getNombre(), solicitudRegistrarAp.getApellido(), solicitudRegistrarAp.getTipodoc(), solicitudRegistrarAp.getDocumento(), solicitudRegistrarAp.getEps(), solicitudRegistrarAp.getCategoria(), solicitudRegistrarAp.getValorcurso(), solicitudRegistrarAp.getAbono(), solicitudRegistrarAp.getAdicional());
    }

    public static Aprendiz reconstruir(Long id, String nombre, String apellido, String tipodoc, String documento, String eps, String categoria, Double valorcurso, Double abono, Double adicional) {
        ValidadorArgumento.validarObligatorio(nombre, "El nombre del aprendiz es obligatorio para el registro");
        ValidadorArgumento.validarObligatorio(documento, "El ... del aprendiz es obligatorio para el registro");

        return new Aprendiz(id, nombre, apellido, tipodoc, documento, eps, categoria, valorcurso, abono, adicional);
    }

    public static Aprendiz guardarAdicional(SolicitudRegistrarAp solicitudRegistrarAp) {
        //double adicional = Aprendiz.calculoRefuerzo(solicitudRegistrarAp.getRefuerzo(), solicitudRegistrarAp.getInasistencia());
        ValidadorArgumento.validarObligatorio(solicitudRegistrarAp.getNombre(), "El nombre del aprendiz es obligatorio para el registro");
        ValidadorArgumento.validarObligatorio(solicitudRegistrarAp.getDocumento(), "El ... del aprendiz es obligatorio para el registro");
        return new Aprendiz(solicitudRegistrarAp.getId(), solicitudRegistrarAp.getNombre(), solicitudRegistrarAp.getApellido(), solicitudRegistrarAp.getTipodoc(), solicitudRegistrarAp.getDocumento(), solicitudRegistrarAp.getEps(), solicitudRegistrarAp.getCategoria(), solicitudRegistrarAp.getValorcurso(), solicitudRegistrarAp.getAbono(), solicitudRegistrarAp.getAdicional());
    }
    public static Double calculoRefuerzo(Long refuerzo, Long inasistenciaTeorica, Long inasistenciaPractica) {
        double adicionalRefuerzo = 0;
        double adicionalInasistenciaTeoria = 0;
        double adicionalInasistenciaPractica = 0;
        double adicional =0;

        if (refuerzo != null){
            adicionalRefuerzo = refuerzo * 25000;
        } if (inasistenciaTeorica != null){
            adicionalInasistenciaTeoria = adicionalInasistenciaTeoria * 10000;
        } if (inasistenciaPractica != null){
            adicionalInasistenciaPractica = adicionalInasistenciaPractica * 20000;
        } else {
            throw new RuntimeException("Procedimiento incorrecto");
        }

        adicional = adicionalRefuerzo + adicionalInasistenciaTeoria + adicionalInasistenciaPractica;
        return adicional;
    }

}
