package com.ceiba.programacion.servicio;

import com.ceiba.aprendiz.puerto.repositorio.RepositorioAprendiz;
import com.ceiba.programacion.modelo.entidad.Programacion;
import com.ceiba.programacion.modelo.entidad.SolicitudProgramar;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;

public class ServicioProgramar {
    private final RepositorioProgramacion repositorioProgramacion;
    private final RepositorioAprendiz repositorioAprendiz;

    public ServicioProgramar(RepositorioProgramacion repositorioProgramacion, RepositorioAprendiz repositorioAprendiz) {
        this.repositorioProgramacion = repositorioProgramacion;
        this.repositorioAprendiz = repositorioAprendiz;
    }

    public Long ejecutar(SolicitudProgramar solicitudProgramar) {
        var programacion = Programacion.crear(solicitudProgramar);
        return repositorioProgramacion.guardar(programacion);
    }

    public Long ejecutar1() {
        return repositorioProgramacion.contadorteoria();
    }

}
