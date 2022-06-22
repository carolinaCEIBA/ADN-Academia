package com.ceiba.factura;

import com.ceiba.programacion.modelo.entidad.SolicitudProgramar;

import java.util.Date;

public class SolicitudProgramarTestDataBuilder {

    private Long idprogramacion;
    private Long clase;
    private Long aprendiz;
    private Long instructor;
    private Date fecha;
    private String hora;
    private String asistencia;

    public SolicitudProgramarTestDataBuilder conIdprogramacion(Long idprogramacion) {
        this.idprogramacion = idprogramacion;
        return this;
    }

    public SolicitudProgramarTestDataBuilder conClase(Long clase) {
        this.clase = clase;
        return this;
    }

    public SolicitudProgramarTestDataBuilder conAprendiz(Long aprendiz) {
        this.aprendiz = aprendiz;
        return this;
    }

    public SolicitudProgramarTestDataBuilder conInstructor(Long instructor) {
        this.instructor = instructor;
        return this;
    }

    public SolicitudProgramarTestDataBuilder conFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public SolicitudProgramarTestDataBuilder conHora(String hora) {
        this.hora = hora;
        return this;
    }

    public SolicitudProgramarTestDataBuilder conAsistencia(String asistencia) {
        this.asistencia = asistencia;
        return this;
    }

    public SolicitudProgramar build() {
        return new SolicitudProgramar(idprogramacion, clase, aprendiz, instructor, fecha, hora, asistencia);
    }

}
