package com.ceiba.aprendiz.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.factura.comando.ComandoSolicitudProgramar;
import com.ceiba.factura.comando.ComandoSolicitudRegistrarAp;
import com.ceiba.factura.comando.manejador.ManejadorRegistrarAp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/academia")
@Tag(name = "Controlador comando aprendiz")
public class ComandoControladorRegistroAp {

    private final ManejadorRegistrarAp manejadorRegistrarAp;

    public ComandoControladorRegistroAp(ManejadorRegistrarAp manejadorRegistrarAp) {
        this.manejadorRegistrarAp = manejadorRegistrarAp;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/aprendiz")
    @Operation(summary = "Registrar Aprendiz", description = "Metodo utilizado para registrar un aprendiz")
    public ComandoRespuesta<Long> registrarap(@RequestBody ComandoSolicitudRegistrarAp comandoSolicitudRegistrarAp){
        return this.manejadorRegistrarAp.ejecutar(comandoSolicitudRegistrarAp);
    }
}
