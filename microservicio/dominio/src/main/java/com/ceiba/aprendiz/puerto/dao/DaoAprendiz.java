package com.ceiba.aprendiz.puerto.dao;

import com.ceiba.aprendiz.modelo.dto.ResumenAprendicesDTO;

import java.util.List;

public interface DaoAprendiz {
    List<ResumenAprendicesDTO> obtenerResumenDeAprendices();
}
