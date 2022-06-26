package com.ceiba.aprendiz.servicio;

import com.ceiba.aprendiz.modelo.entidad.Aprendiz;
import com.ceiba.aprendiz.modelo.entidad.SolicitudRegistrarAp;
import com.ceiba.aprendiz.puerto.repositorio.RepositorioAprendiz;

public class ServicioRegistrarAp {

    private final RepositorioAprendiz repositorioAprendiz;

    public ServicioRegistrarAp(RepositorioAprendiz repositorioAprendiz) {
        this.repositorioAprendiz = repositorioAprendiz;
    }
    public Long ejecutar(SolicitudRegistrarAp solicitudRegistrarAp) {
        var aprendiz = Aprendiz.crear(solicitudRegistrarAp);
        return repositorioAprendiz.guardar(aprendiz);
    }
}
