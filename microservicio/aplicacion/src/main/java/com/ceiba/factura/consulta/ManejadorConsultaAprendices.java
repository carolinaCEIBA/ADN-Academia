package com.ceiba.factura.consulta;

import com.ceiba.aprendiz.modelo.dto.ResumenAprendicesDTO;
import com.ceiba.aprendiz.puerto.dao.DaoAprendiz;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultaAprendices {

    private final DaoAprendiz daoAprendiz;

    public ManejadorConsultaAprendices(DaoAprendiz daoAprendiz) {
        this.daoAprendiz = daoAprendiz;
    }
    public List<ResumenAprendicesDTO> ejecutar(){
        return daoAprendiz.obtenerResumenDeAprendices();
    }
}
