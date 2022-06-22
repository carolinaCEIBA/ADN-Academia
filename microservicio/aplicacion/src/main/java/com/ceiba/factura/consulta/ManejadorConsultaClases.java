package com.ceiba.factura.consulta;

import com.ceiba.aprendiz.modelo.dto.ResumenClasesDTO;
import com.ceiba.aprendiz.puerto.dao.DaoAprendiz;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultaClases {

    private final DaoAprendiz daoAprendiz;

    public ManejadorConsultaClases(DaoAprendiz daoAprendiz) {
        this.daoAprendiz = daoAprendiz;
    }

    public List<ResumenClasesDTO> ejecutar(){
        return daoAprendiz.obtenerResumenDeAprendices();
    }
}
