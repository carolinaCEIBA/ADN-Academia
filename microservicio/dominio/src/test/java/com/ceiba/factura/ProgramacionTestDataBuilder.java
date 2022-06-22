package com.ceiba.factura;

import com.ceiba.programacion.modelo.entidad.Programacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgramacionTestDataBuilder {

    private Long idprogramacion;
    private Long clase;
    private Long aprendiz;
    private Long instructor;
    private Date fecha;
    private String hora;
    private String asistencia;

    public ProgramacionTestDataBuilder conProgramacionPorDefecto() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        this.idprogramacion = 1l;
        this.clase = 1l;
        this.aprendiz = 1l;
        this.instructor = 1l;
        this.fecha = sdf.parse("2020-06-18");
        this.hora = "03:00 pm";
        this.asistencia = "Completa";
        return this;
    }

    public ProgramacionTestDataBuilder conIdprogramacion(Long idprogramacion) {
        this.idprogramacion = idprogramacion;
        return this;
    }

    public ProgramacionTestDataBuilder conClase(Long clase) {
        this.clase = clase;
        return this;
    }

    public ProgramacionTestDataBuilder conAprendiz(Long aprendiz) {
        this.aprendiz = aprendiz;
        return this;
    }

    public ProgramacionTestDataBuilder conInstructor(Long instructor) {
        this.instructor = instructor;
        return this;
    }

    public ProgramacionTestDataBuilder conFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public ProgramacionTestDataBuilder conHora(String hora) {
        this.hora = hora;
        return this;
    }

    public ProgramacionTestDataBuilder conAsistencia(String asistencia) {
        this.asistencia = asistencia;
        return this;
    }

    public Programacion crear() {
        return Programacion.crear(new SolicitudProgramarTestDataBuilder()
                .conIdprogramacion(idprogramacion)
                .conClase(clase)
                .conAprendiz(aprendiz)
                .conInstructor(instructor)
                .conFecha(fecha)
                .conHora(hora)
                .conAsistencia(asistencia)
                .build());
    }


}
