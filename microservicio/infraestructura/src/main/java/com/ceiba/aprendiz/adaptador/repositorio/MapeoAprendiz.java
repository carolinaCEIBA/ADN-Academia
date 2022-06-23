package com.ceiba.aprendiz.adaptador.repositorio;

import com.ceiba.aprendiz.modelo.entidad.Aprendiz;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoAprendiz implements RowMapper<Aprendiz>, MapperResult {

    @Override
    public Aprendiz mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id");
        var nombre = resultSet.getString("nombre");
        var apellido = resultSet.getString("apellido");
        var tipodoc = resultSet.getString("tipodoc");
        var documento = resultSet.getString("documento");
        var eps = resultSet.getString("eps");
        var categoria = resultSet.getString("categoria");
        var inasistencia = resultSet.getLong("inasistencia");
        var valorcurso = resultSet.getDouble("valorcurso");
        var adicional = resultSet.getDouble("adicional");
        var refuerzo = resultSet.getLong("refuerzo");

        return Aprendiz.reconstruir(id, nombre, apellido, tipodoc, documento, eps, categoria, inasistencia, valorcurso, adicional, refuerzo);

    }

}
