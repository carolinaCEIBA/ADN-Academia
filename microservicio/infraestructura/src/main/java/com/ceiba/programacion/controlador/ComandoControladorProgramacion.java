package com.ceiba.programacion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.factura.comando.ComandoSolicitudProgramar;
import com.ceiba.factura.comando.manejador.ManejadorProgramar;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/academia")
@Tag(name = "Controlador comando programacion")
public class ComandoControladorProgramacion {
    private final ManejadorProgramar manejadorProgramar;

    public ComandoControladorProgramacion(ManejadorProgramar manejadorProgramar) {
        this.manejadorProgramar = manejadorProgramar;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/programacion")
    @Operation(summary = "Programar", description = "Metodo utilizado para crear una programacón de una clase")
    public ComandoRespuesta<Long> programar(@RequestBody ComandoSolicitudProgramar comandoSolicitudProgramar){
        return this.manejadorProgramar.ejecutar(comandoSolicitudProgramar);
    }
}
