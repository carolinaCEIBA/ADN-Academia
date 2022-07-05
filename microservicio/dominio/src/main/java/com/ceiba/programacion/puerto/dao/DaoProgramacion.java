package com.ceiba.programacion.puerto.dao;

import com.ceiba.programacion.modelo.dto.ResumenProgramacionDTO;

import java.util.List;

public interface DaoProgramacion {
    List<ResumenProgramacionDTO> obtenerResumenDeProgramacion();

}
