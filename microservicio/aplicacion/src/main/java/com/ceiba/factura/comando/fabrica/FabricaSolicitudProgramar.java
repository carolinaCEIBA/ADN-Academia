package com.ceiba.factura.comando.fabrica;

import com.ceiba.factura.comando.ComandoSolicitudProgramar;
import com.ceiba.programacion.modelo.entidad.SolicitudProgramar;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;
import org.springframework.stereotype.Component;

@Component
public class FabricaSolicitudProgramar {
    private final RepositorioProgramacion repositorioProgramacion;

    public FabricaSolicitudProgramar(RepositorioProgramacion repositorioProgramacion) {
        this.repositorioProgramacion = repositorioProgramacion;
    }

    public SolicitudProgramar crear(ComandoSolicitudProgramar comandoSolicitudProgramar) {
        return new SolicitudProgramar(comandoSolicitudProgramar.getIdprogramacion(), comandoSolicitudProgramar.getClase(), comandoSolicitudProgramar.getAprendiz(), comandoSolicitudProgramar.getInstructor(), comandoSolicitudProgramar.getFecha(),
                comandoSolicitudProgramar.getHora(), comandoSolicitudProgramar.getAsistencia()
        );
    }
}
