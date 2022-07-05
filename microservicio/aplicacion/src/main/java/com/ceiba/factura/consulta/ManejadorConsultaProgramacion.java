package com.ceiba.factura.consulta;
import com.ceiba.programacion.modelo.dto.ResumenProgramacionDTO;
import com.ceiba.programacion.puerto.dao.DaoProgramacion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultaProgramacion {

    private final DaoProgramacion daoProgramacion;

    public ManejadorConsultaProgramacion(DaoProgramacion daoProgramacion) {
        this.daoProgramacion = daoProgramacion;
    }
    public List<ResumenProgramacionDTO> ejecutar(){
        return daoProgramacion.obtenerResumenDeProgramacion();
    }

}
