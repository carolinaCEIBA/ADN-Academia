package com.ceiba.programacion;

import com.ceiba.aprendiz.AprendizTestDataBuilder;
import com.ceiba.aprendiz.modelo.entidad.Aprendiz;
import com.ceiba.aprendiz.puerto.repositorio.RepositorioAprendiz;
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
        Long idprogramacion = 1l;
        Long clase = 1l;
        Long aprendiz = 1l;
        Long instructor = 1l;
        Date fecha = date;
        String hora = "03:00 pm";
        String asistencia = "Si";


        var aprendizObtener = new AprendizTestDataBuilder()
                .conId(3l)
                .conNombre("Carolina").conApellido("Fonseca").conTipoDoc("CC")
                .conDocumento("1000791524").conEps("Sanitas").conCategoria("B1")
                .conValorCurso(1200000).conAbono(600000).conAdicional(70000)
                .crear();

        var repositorioAprendiz = Mockito.mock(RepositorioAprendiz.class);
        Mockito.when(repositorioAprendiz.obtener(Mockito.any())).thenReturn(aprendizObtener);
        var repositorioProgramar = Mockito.mock(RepositorioProgramacion.class);
        Mockito.when(repositorioProgramar.guardar(Mockito.any())).thenReturn(1l);

        var programacion = new SolicitudProgramarTestDataBuilder()
                .conIdprogramacion(idprogramacion)
                .conClase(clase)
                .conAprendiz(aprendiz)
                .conInstructor(instructor)
                .conFecha(fecha)
                .conHora(hora)
                .conAsistencia(asistencia).build();

        var servicioProgramar = new ServicioProgramar(repositorioProgramar, repositorioAprendiz);
        servicioProgramar.ejecutar(programacion);

    }

}
