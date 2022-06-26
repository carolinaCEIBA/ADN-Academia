package com.ceiba.aprendiz.adaptador.repositorio;

import com.ceiba.aprendiz.modelo.entidad.Aprendiz;
import com.ceiba.aprendiz.puerto.repositorio.RepositorioAprendiz;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.programacion.adaptador.repositorio.MapeoProgramacion;
import com.ceiba.programacion.modelo.entidad.Programacion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAprendizMysql implements RepositorioAprendiz {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    @SqlStatement(namespace = "aprendiz", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "aprendiz", value = "obteneraprendiz")
    private static String sqlObtenerAprendiz;

    @SqlStatement(namespace = "aprendiz", value = "obtenerabono")
    private static String sqlObtenerAbono;

    public RepositorioAprendizMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long guardar(Aprendiz aprendiz) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", aprendiz.getId());
        paramSource.addValue("nombre", aprendiz.getNombre());
        paramSource.addValue("apellido", aprendiz.getApellido());
        paramSource.addValue("tipodoc", aprendiz.getTipodoc());
        paramSource.addValue("documento", aprendiz.getDocumento());
        paramSource.addValue("eps", aprendiz.getEps());
        paramSource.addValue("categoria", aprendiz.getCategoria());
        paramSource.addValue("valorcurso", aprendiz.getValorcurso());
        paramSource.addValue("abono", aprendiz.getAbono());
        paramSource.addValue("adicional", aprendiz.getAdicional());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);

    }

    @Override
    public Aprendiz obtener(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerAprendiz, paramSource, new MapeoAprendiz()));
    }

    @Override
    public Double obtenerAbono(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerAbono, paramSource, Double.class));
    }
}
