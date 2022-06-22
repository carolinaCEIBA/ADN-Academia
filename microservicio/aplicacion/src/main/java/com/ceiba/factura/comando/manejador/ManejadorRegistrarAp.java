package com.ceiba.factura.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.aprendiz.servicio.ServicioRegistrarAp;
import com.ceiba.factura.comando.ComandoSolicitudRegistrarAp;
import com.ceiba.factura.comando.fabrica.FabricaSolicitudRegistrarAp;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrarAp implements ManejadorComandoRespuesta<ComandoSolicitudRegistrarAp, ComandoRespuesta<Long>> {

    private final FabricaSolicitudRegistrarAp fabricaSolicitudRegistrarAp;
    private final ServicioRegistrarAp servicioRegistrarAp;

    public ManejadorRegistrarAp(FabricaSolicitudRegistrarAp fabricaSolicitudRegistrarAp, ServicioRegistrarAp servicioRegistrarAp) {
        this.fabricaSolicitudRegistrarAp = fabricaSolicitudRegistrarAp;
        this.servicioRegistrarAp = servicioRegistrarAp;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudRegistrarAp comandoSolicitudRegistrarAp) {
        return new ComandoRespuesta<>(servicioRegistrarAp
                .ejecutar(fabricaSolicitudRegistrarAp.crear(comandoSolicitudRegistrarAp)));
    }
}
