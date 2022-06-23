package com.ceiba.aprendiz.puerto.repositorio;

import com.ceiba.aprendiz.modelo.entidad.Aprendiz;

public interface RepositorioAprendiz {
    Long guardar(Aprendiz aprendiz);

    Aprendiz obtener(Long id);

}
