package com.ceiba.programacion.adaptador.dao;

import com.ceiba.aprendiz.modelo.dto.ResumenAprendicesDTO;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.programacion.modelo.dto.ResumenProgramacionDTO;
import com.ceiba.programacion.puerto.dao.DaoProgramacion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoProgramacionMysql implements DaoProgramacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoListadoProgramacion mapeoListadoProgramacion;

    public DaoProgramacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoListadoProgramacion mapeoListadoProgramacion) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoListadoProgramacion = mapeoListadoProgramacion;
    }

    @SqlStatement(namespace = "programacion", value = "obtenerprogramacion")
    private static String sqlObtenerProgramacion;

    @Override
    public List<ResumenProgramacionDTO> obtenerResumenDeProgramacion() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerProgramacion, mapeoListadoProgramacion);
    }

}
