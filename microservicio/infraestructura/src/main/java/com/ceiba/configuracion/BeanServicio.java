package com.ceiba.configuracion;

import com.ceiba.aprendiz.puerto.repositorio.RepositorioAprendiz;
import com.ceiba.aprendiz.servicio.ServicioRegistrarAp;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;
import com.ceiba.programacion.servicio.ServicioProgramar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioProgramar servicioProgramar(RepositorioProgramacion repositorioProgramacion, RepositorioAprendiz repositorioAprendiz) {
        return new ServicioProgramar(repositorioProgramacion, repositorioAprendiz);
    }
    @Bean
    public ServicioRegistrarAp servicioRegistrarAp(RepositorioAprendiz repositorioAprendiz) {
        return new ServicioRegistrarAp(repositorioAprendiz);
    }

}
