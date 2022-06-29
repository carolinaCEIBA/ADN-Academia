package com.ceiba.programacion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.programacion.modelo.entidad.Programacion;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

//
@Repository
public class RepositorioProgramacionMysql implements RepositorioProgramacion {

    private final MapeoProgramacion mapeoProgramacion;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    @SqlStatement(namespace = "programacion", value = "crear")
    private static String sqlCrear;
    @SqlStatement(namespace = "programacion", value = "contadorteoria")
    private static String sqlContadorTeoria;

    @SqlStatement(namespace = "programacion", value = "contadorpractica")
    private static String sqlContadorPractica;

    @SqlStatement(namespace = "programacion", value = "contadorrefuerzo")
    private static String sqlContadorRefuerzo;

    @SqlStatement(namespace = "programacion", value = "obtenerprogramacionaprendiz")
    private static String sqlObtenerProgramacionAprendiz;

    @SqlStatement(namespace = "programacion", value = "consultadisponibilidad")
    private static String sqlDisponibilidad;

    @SqlStatement(namespace = "programacion", value = "inasistenciateoria")
    private static String sqlInasistenciaTeorica;

    @SqlStatement(namespace = "programacion", value = "inasistenciapractica")
    private static String sqlInasistenciaPractica;

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
    public Long disponibilidad(Long id, Date fecha, String hora){
        LocalDate fechaConvertida = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("instructor", id);
        paramSource.addValue("fecha", fechaConvertida);
        paramSource.addValue("hora", hora);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlDisponibilidad, paramSource, Long.class);
    }

    @Override
    public Long inasistenciaTeorica(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("aprendiz", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlInasistenciaTeorica, paramSource, Long.class);
    }

    @Override
    public Long inasistenciaPractica(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("aprendiz", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlInasistenciaPractica, paramSource, Long.class);
    }

    @Override
    public Long contadorTeoria(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("aprendiz", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlContadorTeoria, paramSource, Long.class);
    }

    @Override
    public Long contadorPractica(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("aprendiz", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlContadorPractica, paramSource, Long.class);

    }

    @Override
    public Long contadorRefuerzo(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("aprendiz", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlContadorRefuerzo, paramSource, Long.class);
    }

}
