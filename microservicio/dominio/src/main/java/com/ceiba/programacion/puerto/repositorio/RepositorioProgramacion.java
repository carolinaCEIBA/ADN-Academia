package com.ceiba.programacion.puerto.repositorio;

import com.ceiba.programacion.modelo.entidad.Programacion;

import java.util.Date;

public interface RepositorioProgramacion {
    Long guardar(Programacion programacion);
    Programacion obtener(Long id);
    Long disponibilidad(Long id, Date fecha, String hora);
    /**Long contador(Long id, Long clase);**/
    Long inasistenciaTeorica(Long id);
    Long inasistenciaPractica(Long id);
    Long contadorTeoria(Long id);
    Long contadorPractica(Long id);
    Long contadorRefuerzo(Long id);
}
