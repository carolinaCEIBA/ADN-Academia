package com.ceiba.programacion.controlador;

import com.ceiba.factura.consulta.ManejadorConsultaProgramacion;
import com.ceiba.programacion.modelo.dto.ResumenProgramacionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academia")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Controlador consulta programacion")
public class ConsultaControladorProgramacion {

    private final ManejadorConsultaProgramacion manejadorConsultaProgramacion;

    public ConsultaControladorProgramacion(ManejadorConsultaProgramacion manejadorConsultaProgramacion) {
        this.manejadorConsultaProgramacion = manejadorConsultaProgramacion;
    }

    @GetMapping("/resumenProgramaciones")
    @Operation(summary = "Consultar programaciones", description = "Metodo utilizado para listar todas las programaciones")
    public List<ResumenProgramacionDTO> obtenerProgramaciones(){ return manejadorConsultaProgramacion.ejecutar();}
}
