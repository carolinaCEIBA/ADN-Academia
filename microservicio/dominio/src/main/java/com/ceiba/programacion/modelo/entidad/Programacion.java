package com.ceiba.programacion.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;


public class Programacion {
    private Long idprogramacion;
    private Long clase;
    private Long aprendiz;
    private Long instructor;
    private Date fecha;
    private String hora;
    private String asistencia;

    public Long getIdprogramacion() {
        return idprogramacion;
    }

    public Long getClase() {
        return clase;
    }

    public Long getAprendiz() {
        return aprendiz;
    }

    public Long getInstructor() {
        return instructor;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getAsistencia() {
        return asistencia;
    }

    private RepositorioProgramacion repositorioProgramacion;
    public Programacion(Long idprogramacion, Long clase, Long aprendiz, Long instructor, Date fecha, String hora, String asistencia) {
        this.idprogramacion = idprogramacion;
        this.clase = clase;
        this.aprendiz = aprendiz;
        this.instructor = instructor;
        this.fecha = fecha;
        this.hora = hora;
        this.asistencia = asistencia;
    }

    public static Programacion crear(SolicitudProgramar solicitudProgramar) {
        Date fechaHabil = Programacion.validacionClasePractica(solicitudProgramar.getFecha(), solicitudProgramar.getClase());
        //ValidadorArgumento.validarObligatorio(solicitudProgramar.getIdprogramacion(), "El id para la programación es obligatorio");
        ValidadorArgumento.validarObligatorio(solicitudProgramar.getClase(), "El tipo de clase es requerido para programar");
        ValidadorArgumento.validarObligatorio(solicitudProgramar.getAprendiz(), "El aprendiz es requerido para programar");
        ValidadorArgumento.validarObligatorio(solicitudProgramar.getInstructor(), "El instructor es requerido para programar");
        ValidadorArgumento.validarObligatorio(solicitudProgramar.getFecha(), "La fecha es obligatoria para programar la clase");
        ValidadorArgumento.validarObligatorio(solicitudProgramar.getHora(), "La hora es obligatoria para programar la clase");

        return new Programacion(solicitudProgramar.getIdprogramacion(), solicitudProgramar.getClase(), solicitudProgramar.getAprendiz(), solicitudProgramar.getInstructor(), fechaHabil, solicitudProgramar.getHora(), solicitudProgramar.getAsistencia());
    }

    public static Date validacionClasePractica(Date fecha, Long clase) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        Date fechaHabil = null;
        if (clase == 2 || clase == 3){
            if (!(dayOfWeek == 6 || dayOfWeek == 7)){
                fechaHabil = fecha;
            } else {
                throw new RuntimeException("La clase no puede ser programada este dia");
            }
        } else if (clase == 1) {
            fechaHabil = fecha;
        }
        return fechaHabil;
    }

}
