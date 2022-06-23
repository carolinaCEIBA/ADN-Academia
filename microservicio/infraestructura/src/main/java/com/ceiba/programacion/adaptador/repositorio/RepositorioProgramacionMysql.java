package com.ceiba.programacion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.programacion.modelo.entidad.Programacion;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

//
@Repository
public class RepositorioProgramacionMysql implements RepositorioProgramacion {

    private final MapeoProgramacion mapeoProgramacion;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    @SqlStatement(namespace = "programacion", value = "crear")
    private static String sqlCrear;
    @SqlStatement(namespace = "programacion", value = "contadorteoria")
    private static String sqlContadorTeoria;

    @SqlStatement(namespace = "programacion", value = "obtenerprogramacionaprendiz")
    private static String sqlObtenerProgramacionAprendiz;
    public RepositorioProgramacionMysql(MapeoProgramacion mapeoProgramacion, CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.mapeoProgramacion = mapeoProgramacion;
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
    public Programacion obtener(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("aprendiz", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerProgramacionAprendiz, paramSource, new MapeoProgramacion()));
    }
    @Override
    public Long contadorteoria() {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("aprendiz", 2);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlContadorTeoria, paramSource, Long.class);

    }

}
