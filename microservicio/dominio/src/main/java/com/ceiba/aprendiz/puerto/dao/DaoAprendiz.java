package com.ceiba.aprendiz.puerto.dao;

import com.ceiba.aprendiz.modelo.dto.ResumenClasesDTO;

import java.util.List;

public interface DaoAprendiz {
    List<ResumenClasesDTO> obtenerResumenDeAprendices();
}
