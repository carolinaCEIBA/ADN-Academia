package com.ceiba.aprendiz.adaptador.dao;

import com.ceiba.aprendiz.modelo.dto.ResumenAprendicesDTO;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoListadoAprendices implements RowMapper<ResumenAprendicesDTO>, MapperResult {

    @Override
    public ResumenAprendicesDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException{
        var id = resultSet.getLong("id");
        var nombre = resultSet.getString("nombre");
        var apellido = resultSet.getString("apellido");
        var tipodoc = resultSet.getString("tipodoc");
        var documento = resultSet.getString("documento");
        var eps = resultSet.getString("eps");
        var categoria = resultSet.getString("categoria");
        var valorcurso = resultSet.getDouble("valorcurso");
        var abono = resultSet.getDouble("abono");

        return new ResumenAprendicesDTO(id, nombre, apellido, tipodoc, documento, eps, categoria, valorcurso, abono);

    }

}
