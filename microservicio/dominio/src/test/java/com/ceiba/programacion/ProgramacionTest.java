package com.ceiba.programacion;

import com.ceiba.BasePrueba;
import com.ceiba.aprendiz.AprendizTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.excepciones.ExcepcionInstructor;
import com.ceiba.excepciones.ExcepcionTeoria;
import com.ceiba.excepciones.ExcepcionValidacionClase;
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
    String dateInString2 = "2018-08-18";

    Date date = formatter.parse(dateInString);
    Date date2 = formatter.parse(dateInString2);


    public ProgramacionTest() throws ParseException {
    }

        @Test
        void deberiaCrearProgramacion(){

            var programacion = new ProgramacionTestDataBuilder()
                    .conIdprogramacion(1l)
                    .conClase(1l)
                    .conAprendiz(2l)
                    .conInstructor(1l)
                    .conFecha(date2)
                    .conHora("03:00 pm")
                    .conAsistencia("Si").crear();

            Assertions.assertEquals(1l, programacion.getIdprogramacion());
            Assertions.assertEquals(1l, programacion.getClase());
            Assertions.assertEquals(2l, programacion.getAprendiz());
            Assertions.assertEquals(1l, programacion.getInstructor());
            Assertions.assertEquals(date2, programacion.getFecha());
            Assertions.assertEquals("03:00 pm", programacion.getHora());
            Assertions.assertEquals("Si", programacion.getAsistencia());


        }

        @Test
        void deberiarReconstruirProgramacion() throws ParseException {

            var programacion = new ProgramacionTestDataBuilder()
                    .conIdprogramacion(1l)
                    .conClase(1l)
                    .conAprendiz(2l)
                    .conInstructor(1l)
                    .conFecha(date2)
                    .conHora("03:00 pm")
                    .conAsistencia("Si").reconstruir();

            Assertions.assertEquals(1l, programacion.getIdprogramacion());
            Assertions.assertEquals(1l, programacion.getClase());
            Assertions.assertEquals(2l, programacion.getAprendiz());
            Assertions.assertEquals(1l, programacion.getInstructor());
            Assertions.assertEquals(date2, programacion.getFecha());
            Assertions.assertEquals("03:00 pm", programacion.getHora());
            Assertions.assertEquals("Si", programacion.getAsistencia());

        }

        @Test
        void orquestarCaso1(){
            Programacion.orquestadorClase(10l, null, 1l, ConstantesProgramacion.B1, ConstantesProgramacion.ABONO_B1);
        }

        @Test
        void orquestarCaso2(){
            Programacion.orquestadorClase(ConstantesProgramacion.CLASESTEORIA_B1, 2l, 2l, ConstantesProgramacion.B1, ConstantesProgramacion.TOTAL_B1);
        }

        @Test
        void orquestarCaso3(){
            Programacion.orquestadorClase(10l, null, 1l, ConstantesProgramacion.C1, ConstantesProgramacion.ABONO_C1);
        }

        @Test
        void orquestarCaso4(){
            Programacion.orquestadorClase(ConstantesProgramacion.CLASESTEORIA_C1, 2l, 2l, ConstantesProgramacion.C1, ConstantesProgramacion.TOTAL_C1);
        }

        @Test
        void orquestarCaso5(){
            BasePrueba.assertThrows(() -> Programacion.orquestadorClase(2l, 2l, 2l, ConstantesProgramacion.C1, ConstantesProgramacion.TOTAL_C1),
                    ExcepcionTeoria.class,
                    ConstantesProgramacion.MENSAJE_TEORIA);
        }

        @Test
        void orquestarCaso6(){
            BasePrueba.assertThrows(() -> Programacion.orquestadorClase(2l, 2l, 2l, ConstantesProgramacion.B1, ConstantesProgramacion.TOTAL_B1),
                    ExcepcionTeoria.class,
                    ConstantesProgramacion.MENSAJE_TEORIA);
        }

        @Test
        void orquestarCaso7(){
            BasePrueba.assertThrows(() -> Programacion.orquestadorClase(31l, null, 1l, ConstantesProgramacion.C1, ConstantesProgramacion.TOTAL_C1),
                    ExcepcionValidacionClase.class,
                    ConstantesProgramacion.MENSAJE_CLASE);
        }

        @Test
        void orquestarCaso8(){
            BasePrueba.assertThrows(() -> Programacion.orquestadorClase(26l, null, 1l, ConstantesProgramacion.B1, ConstantesProgramacion.TOTAL_B1),
                    ExcepcionValidacionClase.class,
                    ConstantesProgramacion.MENSAJE_CLASE);
        }

        @Test
        void orquestarCaso9(){
            BasePrueba.assertThrows(() -> Programacion.orquestadorClase(0l, null, 2l, ConstantesProgramacion.B1, ConstantesProgramacion.TOTAL_B1),
                    ExcepcionTeoria.class,
                    ConstantesProgramacion.MENSAJE_TEORIA);
        }

        @Test
        void orquestarCaso10(){
            BasePrueba.assertThrows(() -> Programacion.orquestadorClase(26l, 0l, 1l, ConstantesProgramacion.B1, ConstantesProgramacion.TOTAL_B1),
                    ExcepcionValidacionClase.class,
                    ConstantesProgramacion.MENSAJE_CLASE);
        }

        @Test
        void validacionDisponibilidad(){
            BasePrueba.assertThrows(() -> Programacion.disponibilidadInstructor(2l),
                    ExcepcionInstructor.class,
                    ConstantesProgramacion.MENSAJE_INSTRUCTOR);
        }

}
