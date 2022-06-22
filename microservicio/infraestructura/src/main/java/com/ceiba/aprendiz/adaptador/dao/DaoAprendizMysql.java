package com.ceiba.aprendiz.adaptador.dao;

import com.ceiba.aprendiz.modelo.dto.ResumenClasesDTO;
import com.ceiba.aprendiz.puerto.dao.DaoAprendiz;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoAprendizMysql implements DaoAprendiz {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoListadoAprendices mapeoListadoAprendices;

    @SqlStatement(namespace = "aprendiz", value = "obteneraprendices")
    private static String sqlObtenerAprendices;

    @SqlStatement(namespace = "aprendiz", value = "obteneraprendiz")
    private static String sqlObtenerAprendiz;

    public DaoAprendizMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoListadoAprendices mapeoListadoAprendices) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoListadoAprendices = mapeoListadoAprendices;
    }

    @Override
    public List<ResumenClasesDTO> obtenerResumenDeAprendices(){
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerAprendices, mapeoListadoAprendices);
    }
/**
    @Override
    public Aprendiz obtenerPorId(Long id){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerAprendiz,
                        paramSource, new MapeoAprendiz()));
    }**/

}
