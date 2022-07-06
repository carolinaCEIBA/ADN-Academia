package com.ceiba.programacion.controlador;

import com.ceiba.factura.comando.ComandoSolicitudProgramar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComandoProgramarTestDataBuilder {

    private Long idprogramacion;
    private Long clase;
    private Long aprendiz;
    private Long instructor;
    private Date fecha;
    private String hora;
    private String asistencia;

    public ComandoProgramarTestDataBuilder programacionPorDefecto() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        this.idprogramacion = 2l;
        this.clase = 1l;
        this.aprendiz = 5l;
        this.instructor = 2l;
        this.fecha = sdf.parse("2021/06/18");
        this.hora = "04:00 pm";
        this.asistencia = "No";
        return this;
    }

    public ComandoSolicitudProgramar build() {
        return new ComandoSolicitudProgramar(this.idprogramacion, this.clase, this.aprendiz, this.instructor, this.fecha, this.hora, this.asistencia);
    }
}
