package com.ceiba.aprendiz.controlador;

import com.ceiba.aprendiz.modelo.dto.ResumenAprendicesDTO;
import com.ceiba.factura.consulta.ManejadorConsultaAprendices;
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
@Tag(name = "Controlador consulta aprendices")
public class ConsultaControladorAprendices {

    private final ManejadorConsultaAprendices manejadorConsultaAprendices;

    public ConsultaControladorAprendices(ManejadorConsultaAprendices manejadorConsultaAprendices) {
        this.manejadorConsultaAprendices = manejadorConsultaAprendices;
    }

    @GetMapping("/resumenAprendices")
    @Operation(summary = "Consultar aprendices", description = "Metodo utilizado para listar todos los aprendices")
    public List<ResumenAprendicesDTO> obtenerAprendices(){ return manejadorConsultaAprendices.ejecutar();}
}
