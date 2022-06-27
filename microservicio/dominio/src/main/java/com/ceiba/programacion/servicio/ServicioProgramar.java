package com.ceiba.programacion.servicio;

import com.ceiba.aprendiz.modelo.entidad.Aprendiz;
import com.ceiba.aprendiz.puerto.repositorio.RepositorioAprendiz;
import com.ceiba.programacion.modelo.entidad.Programacion;
import com.ceiba.programacion.modelo.entidad.SolicitudProgramar;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;

import java.util.Date;

public class ServicioProgramar {
    private final RepositorioProgramacion repositorioProgramacion;
    private final RepositorioAprendiz repositorioAprendiz;

    public ServicioProgramar(RepositorioProgramacion repositorioProgramacion, RepositorioAprendiz repositorioAprendiz) {
        this.repositorioProgramacion = repositorioProgramacion;
        this.repositorioAprendiz = repositorioAprendiz;
    }

    public Long ejecutar(SolicitudProgramar solicitudProgramar) {
        /**var contador = this.ejecutarContador(solicitudProgramar.getAprendiz(), solicitudProgramar.getClase());**/
        var disponibilidad = this.validarDisponibilidad(solicitudProgramar.getInstructor(), solicitudProgramar.getFecha(), solicitudProgramar.getHora());
        var contadorTeoria = this.ejecutarContadorTeoria(solicitudProgramar.getAprendiz());
        var contadorPractica = this.ejecutarContadorPractica(solicitudProgramar.getAprendiz());
        var contadorRefuerzo = this.ejecutarContadorRefuerzo(solicitudProgramar.getAprendiz());
        var inasistenciaTeorica = this.inasistenciaTeorica(solicitudProgramar.getAprendiz());
        var inasistenciaPractica = this.inasistenciaPractica(solicitudProgramar.getAprendiz());
        var abono = repositorioAprendiz.obtenerAbono(solicitudProgramar.getAprendiz());
        var aprendiz = repositorioAprendiz.obtener(solicitudProgramar.getAprendiz());
        var adicional = Aprendiz.calculoAdicional(contadorRefuerzo, inasistenciaTeorica, inasistenciaPractica);
        Programacion.orquestadorClase(contadorTeoria, contadorPractica, solicitudProgramar.getClase(), aprendiz.getCategoria());
        Programacion.disponibilidadInstructor(disponibilidad);
        Programacion.verificacionPago(abono, solicitudProgramar.getClase(), aprendiz.getCategoria());
        Aprendiz.guardarAdicional(solicitudProgramar.getAprendiz(), adicional);
        var programacion = Programacion.crear(solicitudProgramar);
        return repositorioProgramacion.guardar(programacion);
    }

    public Long ejecutarContadorTeoria(Long id) {
        return repositorioProgramacion.contadorTeoria(id);
    }

    public Long ejecutarContadorPractica(Long id) {
        return repositorioProgramacion.contadorPractica(id);
    }

    public Long ejecutarContadorRefuerzo(Long id) {
        return repositorioProgramacion.contadorRefuerzo(id);
    }

    /**public Long ejecutarContador(Long id, Long clase) {
        return repositorioProgramacion.contador(id, clase);
    }**/

    public Long validarDisponibilidad(Long id, Date fecha, String hora){
        return repositorioProgramacion.disponibilidad(id, fecha, hora);
    }

    public Long inasistenciaTeorica(Long id) {
        return repositorioProgramacion.inasistenciaTeorica(id);
    }

    public Long inasistenciaPractica(Long id) {
        return repositorioProgramacion.inasistenciaPractica(id);
    }


}
