package com.ceiba.aprendiz.adaptador.dao;

import com.ceiba.aprendiz.modelo.dto.ResumenClasesDTO;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoListadoAprendices implements RowMapper<ResumenClasesDTO>, MapperResult {

    @Override
    public ResumenClasesDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException{
        var id = resultSet.getLong("id");
        var nombre = resultSet.getString("nombre");
        var apellido = resultSet.getString("apellido");
        var tipodoc = resultSet.getString("tipodoc");
        var documento = resultSet.getString("documento");
        var eps = resultSet.getString("eps");
        var categoria = resultSet.getString("categoria");
        var codigo = resultSet.getString("codigo");

        return new ResumenClasesDTO(id, nombre, apellido, tipodoc, documento, eps, categoria, codigo);

    }

}
