package com.ceiba.factura;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgramacionTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2018/08/16";
    Date date = formatter.parse(dateInString);

    public ProgramacionTest() throws ParseException {
    }

    @Test
    void deberiaCrearProgramacion(){
        Long idprogramacion = 1l;
        Long clase = 1l;
        Long aprendiz = 1l;
        Long instructor = 1l;
        Date fecha = date;
        String hora = "03:00 pm";
        String asistencia = "Completa";


        var programacion = new ProgramacionTestDataBuilder()
                .conIdprogramacion(idprogramacion)
                .conClase(clase)
                .conAprendiz(aprendiz)
                .conInstructor(instructor)
                .conFecha(fecha)
                .conHora(hora)
                .conAsistencia(asistencia).crear();

        Assertions.assertEquals(1l, programacion.getIdprogramacion());
        Assertions.assertEquals(1l, programacion.getClase());
        Assertions.assertEquals(1l, programacion.getAprendiz());
        Assertions.assertEquals(1l, programacion.getInstructor());
        Assertions.assertEquals(date, programacion.getFecha());
        Assertions.assertEquals("03:00 pm", programacion.getHora());
        Assertions.assertEquals("Completa", programacion.getAsistencia());

    }

}
