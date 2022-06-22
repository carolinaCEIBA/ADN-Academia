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
    private Long inasistencia;
    private double valorcurso;
    private double adicional;

    private Long refuerzo;

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

    public Long getInasistencia() {
        return inasistencia;
    }

    public double getValorcurso() {
        return valorcurso;
    }

    public double getAdicional() {
        return adicional;
    }

    public Long getRefuerzo() {
        return refuerzo;
    }

    public Aprendiz(Long id, String nombre, String apellido, String tipodoc, String documento, String eps, String categoria, Long inasistencia, double valorcurso, double adicional, Long refuerzo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipodoc = tipodoc;
        this.documento = documento;
        this.eps = eps;
        this.categoria = categoria;
        this.inasistencia = inasistencia;
        this.valorcurso = valorcurso;
        this.adicional = adicional;
        this.refuerzo = refuerzo;

    }


    public static Aprendiz crear(SolicitudRegistrarAp solicitudRegistrarAp) {
        double adicional = Aprendiz.calculoRefuerzo(solicitudRegistrarAp.getRefuerzo(), solicitudRegistrarAp.getInasistencia());
        ValidadorArgumento.validarObligatorio(solicitudRegistrarAp.getNombre(), "El nombre del aprendiz es obligatorio para el registro");
        ValidadorArgumento.validarObligatorio(solicitudRegistrarAp.getDocumento(), "El ... del aprendiz es obligatorio para el registro");
        return new Aprendiz(solicitudRegistrarAp.getId(), solicitudRegistrarAp.getNombre(), solicitudRegistrarAp.getApellido(), solicitudRegistrarAp.getTipodoc(), solicitudRegistrarAp.getDocumento(), solicitudRegistrarAp.getEps(), solicitudRegistrarAp.getCategoria(), solicitudRegistrarAp.getInasistencia(), solicitudRegistrarAp.getValorcurso(), adicional, solicitudRegistrarAp.getRefuerzo());
    }

    public static Double calculoRefuerzo(Long refuerzo, Long inasistencia) {
        double adicionalRefuerzo = 0;
        double adicionalInasistencia = 0;
        double adicional =0;

        if (refuerzo != null){
            adicionalRefuerzo = refuerzo * 25000;
        } if (inasistencia != null){
            adicionalInasistencia = inasistencia * 20000;
        }

        adicional = adicionalRefuerzo + adicionalInasistencia;
        return adicional;
    }

}
