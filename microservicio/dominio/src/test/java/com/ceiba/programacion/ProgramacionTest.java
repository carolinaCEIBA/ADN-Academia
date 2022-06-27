package com.ceiba.programacion;

import com.ceiba.BasePrueba;
import com.ceiba.aprendiz.AprendizTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.programacion.modelo.entidad.ConstantesProgramacion;
import com.ceiba.programacion.modelo.entidad.Programacion;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgramacionTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2018-08-16";
    Date date = formatter.parse(dateInString);

    public ProgramacionTest() throws ParseException {
    }

        @Test
        void deberiaCrearProgramacion(){
            Long idprogramacion = 1l;
            Long clase = 1l;
            Long aprendiz = 2l;
            Long instructor = 1l;
            Date fecha = date;
            String hora = "03:00 pm";
            String asistencia = "Si";


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
            Assertions.assertEquals(2l, programacion.getAprendiz());
            Assertions.assertEquals(1l, programacion.getInstructor());
            Assertions.assertEquals(date, programacion.getFecha());
            Assertions.assertEquals("03:00 pm", programacion.getHora());
            Assertions.assertEquals("Si", programacion.getAsistencia());


        }

        @Test
        void deberiarReconstruirProgramacion(){
            Long idprogramacion = 1l;
            Long clase = 1l;
            Long aprendiz = 2l;
            Long instructor = 1l;
            Date fecha = date;
            String hora = "03:00 pm";
            String asistencia = "Si";


            var programacion = new ProgramacionTestDataBuilder()
                    .conIdprogramacion(idprogramacion)
                    .conClase(clase)
                    .conAprendiz(aprendiz)
                    .conInstructor(instructor)
                    .conFecha(fecha)
                    .conHora(hora)
                    .conAsistencia(asistencia).reconstruir();

            Assertions.assertEquals(1l, programacion.getIdprogramacion());
            Assertions.assertEquals(1l, programacion.getClase());
            Assertions.assertEquals(2l, programacion.getAprendiz());
            Assertions.assertEquals(1l, programacion.getInstructor());
            Assertions.assertEquals(date, programacion.getFecha());
            Assertions.assertEquals("03:00 pm", programacion.getHora());
            Assertions.assertEquals("Si", programacion.getAsistencia());

        }

        @Test
        void deberiaOrquestar(){
            var repositorioProgramacion = Mockito.mock(RepositorioProgramacion.class);
            Mockito.when(repositorioProgramacion.contadorTeoria(Mockito.any())).thenReturn(10l);
            Mockito.when(repositorioProgramacion.contadorPractica(Mockito.any())).thenReturn(null);
            Programacion.orquestadorClase(10l, null, 1l, "C1" );
        }

        @Test
        void deberiaOrquestarCaso2(){
            var repositorioProgramacion = Mockito.mock(RepositorioProgramacion.class);
            Mockito.when(repositorioProgramacion.contadorTeoria(Mockito.any())).thenReturn(30l);
            Mockito.when(repositorioProgramacion.contadorPractica(Mockito.any())).thenReturn(2l);
            Programacion.orquestadorClase(30l, 2l, 2l, "C1" );
        }


}
