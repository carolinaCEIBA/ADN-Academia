package com.ceiba.aprendiz.controlador;

import com.ceiba.aprendiz.modelo.dto.ResumenClasesDTO;
import com.ceiba.factura.consulta.ManejadorConsultaClases;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academia")
@Tag(name = "Controlador consulta aprendices")
public class ConsultaControladorAprendices {

    private final ManejadorConsultaClases manejadorConsultaClases;

    public ConsultaControladorAprendices(ManejadorConsultaClases manejadorConsultaClases) {
        this.manejadorConsultaClases = manejadorConsultaClases;
    }


    @GetMapping("/resumenAprendices")
    @Operation(summary = "Consultar aprendices", description = "Metodo utilizado para listar todos los aprendices")
    public List<ResumenClasesDTO> obtenerClasesPorId(){ return manejadorConsultaClases.ejecutar();}
}
