package com.ceiba.programacion;

import com.ceiba.aprendiz.AprendizTestDataBuilder;
import com.ceiba.aprendiz.modelo.entidad.Aprendiz;
import com.ceiba.aprendiz.puerto.repositorio.RepositorioAprendiz;
import com.ceiba.programacion.modelo.entidad.Programacion;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;
import com.ceiba.programacion.servicio.ServicioProgramar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServicioProgramarTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2018-08-16";
    String dateInString2 = "2018-08-18";

    Date date = formatter.parse(dateInString);
    Date date2 = formatter.parse(dateInString2);


    public ServicioProgramarTest() throws ParseException {
    }

    @Test
    void deberiaProgramarExitosamente(){

        var aprendizObtener = new AprendizTestDataBuilder().conAprendizPorDefecto()
                .conAbono(1500000.0)
                .crear();
        var repositorioAprendiz = Mockito.mock(RepositorioAprendiz.class);
        Mockito.when(repositorioAprendiz.obtener(Mockito.any())).thenReturn(aprendizObtener);
        var repositorioProgramar = Mockito.mock(RepositorioProgramacion.class);
        Mockito.when(repositorioAprendiz.obtenerAbono(Mockito.any())).thenReturn(1500000.0);
        Mockito.when(repositorioProgramar.guardar(Mockito.any())).thenReturn(1l);
        Mockito.when(repositorioProgramar.contadorTeoria(Mockito.any())).thenReturn(30l);
        Mockito.when(repositorioProgramar.contadorPractica(Mockito.any())).thenReturn(2l);

        var programacion = new SolicitudProgramarTestDataBuilder()
                .conIdprogramacion(1l)
                .conClase(2l)
                .conAprendiz(5l)
                .conInstructor(1l)
                .conFecha(date)
                .conHora("03:00 pm")
                .conAsistencia("Si").build();

        var servicioProgramar = new ServicioProgramar(repositorioProgramar, repositorioAprendiz);
        servicioProgramar.ejecutar(programacion);

    }

}
