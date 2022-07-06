package com.ceiba.programacion.adaptador.dao;

import com.ceiba.aprendiz.modelo.dto.ResumenAprendicesDTO;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.programacion.modelo.dto.ResumenProgramacionDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoListadoProgramacion implements RowMapper<ResumenProgramacionDTO>, MapperResult {

    @Override
    public ResumenProgramacionDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var clase = resultSet.getString("descripcion");
        var aprendiz = resultSet.getString("nombre");
        var instructor = resultSet.getString("nombreins");
        var fecha = resultSet.getDate("fecha");
        var hora = resultSet.getString("hora");
        var asistencia = resultSet.getString("asistencia");

        return new ResumenProgramacionDTO(clase, aprendiz, instructor, fecha, hora, asistencia);

    }
}
