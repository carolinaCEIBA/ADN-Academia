package com.ceiba.programacion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.programacion.modelo.entidad.Programacion;
import com.ceiba.programacion.puerto.dao.DaoProgramacion;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
//
@Repository
public class RepositorioProgramacionMysql implements RepositorioProgramacion {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    @SqlStatement(namespace = "programacion", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "programacion", value = "contadorteoria")
    private static String sqlContadorTeoria;
    public RepositorioProgramacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @Override
    public Long guardar(Programacion programacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idprogramacion", programacion.getIdprogramacion());
        paramSource.addValue("clase", programacion.getClase());
        paramSource.addValue("aprendiz", programacion.getAprendiz());
        paramSource.addValue("instructor", programacion.getInstructor());
        paramSource.addValue("fecha", programacion.getFecha());
        paramSource.addValue("hora", programacion.getHora());
        paramSource.addValue("asistencia", programacion.getAsistencia());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }

    @Override
    public Long contadorteoria() {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("aprendiz", 2);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlContadorTeoria, paramSource, Long.class);

    }

}
