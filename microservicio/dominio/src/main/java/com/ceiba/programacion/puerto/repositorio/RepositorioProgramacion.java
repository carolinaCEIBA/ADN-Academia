package com.ceiba.programacion.puerto.repositorio;

import com.ceiba.programacion.modelo.entidad.Programacion;

public interface RepositorioProgramacion {
    Long guardar(Programacion programacion);
    Programacion obtener(Long id);
    Long contadorteoria();
}
