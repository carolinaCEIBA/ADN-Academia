package com.ceiba.programacion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.programacion.modelo.entidad.Programacion;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Component
public class MapeoProgramacion implements RowMapper<Programacion>, MapperResult {

    @Override
    public Programacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var idprogramacion = resultSet.getLong("id");
        var clase = resultSet.getLong("clase");
        var aprendiz = resultSet.getLong("aprendiz");
        var instructor = resultSet.getLong("instructor");
        var fecha = resultSet.getDate("fecha");
        var hora = resultSet.getString("hora");
        var asistencia = resultSet.getString("asistencia");


        return Programacion.reconstruir(idprogramacion, clase, aprendiz, instructor, fecha, hora, asistencia);
    }

}
