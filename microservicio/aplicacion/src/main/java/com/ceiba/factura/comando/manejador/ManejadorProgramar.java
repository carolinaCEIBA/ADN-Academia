package com.ceiba.factura.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.factura.comando.ComandoSolicitudProgramar;
import com.ceiba.factura.comando.fabrica.FabricaSolicitudProgramar;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.programacion.servicio.ServicioProgramar;
import org.springframework.stereotype.Component;

@Component
public class ManejadorProgramar implements ManejadorComandoRespuesta<ComandoSolicitudProgramar, ComandoRespuesta<Long>> {
    private final FabricaSolicitudProgramar fabricaSolicitudProgramar;
    private final ServicioProgramar servicioProgramar;

    public ManejadorProgramar(FabricaSolicitudProgramar fabricaSolicitudProgramar, ServicioProgramar servicioProgramar) {
        this.fabricaSolicitudProgramar = fabricaSolicitudProgramar;
        this.servicioProgramar = servicioProgramar;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudProgramar comandoSolicitudProgramar) {
        return new ComandoRespuesta<>(servicioProgramar
                .ejecutar(fabricaSolicitudProgramar.crear(comandoSolicitudProgramar)));
    }
}
