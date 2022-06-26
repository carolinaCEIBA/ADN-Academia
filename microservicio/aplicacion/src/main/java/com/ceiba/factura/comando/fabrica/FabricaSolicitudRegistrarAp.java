package com.ceiba.factura.comando.fabrica;

import com.ceiba.aprendiz.modelo.entidad.SolicitudRegistrarAp;
import com.ceiba.aprendiz.puerto.repositorio.RepositorioAprendiz;
import com.ceiba.factura.comando.ComandoSolicitudRegistrarAp;
import org.springframework.stereotype.Component;

@Component
public class FabricaSolicitudRegistrarAp {
    private final RepositorioAprendiz repositorioAprendiz;

    public FabricaSolicitudRegistrarAp(RepositorioAprendiz repositorioAprendiz) {
        this.repositorioAprendiz = repositorioAprendiz;
    }
    public SolicitudRegistrarAp crear(ComandoSolicitudRegistrarAp comandoSolicitudRegistrarAp) {
        return new SolicitudRegistrarAp(comandoSolicitudRegistrarAp.getId(), comandoSolicitudRegistrarAp.getNombre(), comandoSolicitudRegistrarAp.getApellido(), comandoSolicitudRegistrarAp.getTipodoc(), comandoSolicitudRegistrarAp.getDocumento(), comandoSolicitudRegistrarAp.getEps(),
                comandoSolicitudRegistrarAp.getCategoria(), comandoSolicitudRegistrarAp.getValorcurso(), comandoSolicitudRegistrarAp.getAbono(), comandoSolicitudRegistrarAp.getAdicional()
        );
    }
}
