package com.ceiba.programacion.controlador;

import com.ceiba.factura.comando.ComandoSolicitudProgramar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ComandoProgramarTestDataBuilder {

    private Long idprogramacion;
    private Long clase;
    private Long aprendiz;
    private Long instructor;
    private Date fecha;
    private String hora;
    private String asistencia;

    /**public ComandoFacturarTestDataBuilder crearPorDefecto() throws ParseException {
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

    public ComandoSolicitudProgramar build() {
        return new ComandoSolicitudProgramar(this.idprogramacion, this.clase, this.aprendiz, this.instructor, this.fecha, this.hora, this.asistencia);
    }**/
}
