package com.ceiba.programacion.modelo.entidad;


import com.ceiba.excepciones.*;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;


public class Programacion {

    private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.Utilidades");
    private Long idprogramacion;
    private Long clase;
    private Long aprendiz;
    private Long instructor;
    private Date fecha;
    private String hora;
    private String asistencia;

    public Long getIdprogramacion() {
        return idprogramacion;
    }

    public Long getClase() {
        return clase;
    }

    public Long getAprendiz() {
        return aprendiz;
    }

    public Long getInstructor() {
        return instructor;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public Programacion(Long idprogramacion, Long clase, Long aprendiz, Long instructor, Date fecha, String hora, String asistencia) {
        this.idprogramacion = idprogramacion;
        this.clase = clase;
        this.aprendiz = aprendiz;
        this.instructor = instructor;
        this.fecha = fecha;
        this.hora = hora;
        this.asistencia = asistencia;
    }

    public static Programacion crear(SolicitudProgramar solicitudProgramar) {
        Date fechaHabil = Programacion.validacionFechaClasePractica(solicitudProgramar.getFecha(), solicitudProgramar.getClase());
        return new Programacion(solicitudProgramar.getIdprogramacion(), solicitudProgramar.getClase(), solicitudProgramar.getAprendiz(), solicitudProgramar.getInstructor(), fechaHabil, solicitudProgramar.getHora(), solicitudProgramar.getAsistencia());
    }

    public static Programacion reconstruir(Long idprogramacion, Long clase, Long aprendiz, Long instructor, Date fecha, String hora, String asistencia) {
        Date fechaHabil = Programacion.validacionFechaClasePractica(fecha, clase);
        return new Programacion(idprogramacion, clase, aprendiz, instructor, fechaHabil, hora, asistencia);
    }

    public static void orquestadorClase(Long contadorTeoria, Long contadorPractica, Long clase, String categoria, Double abono) {
        if (clase.equals(ConstantesProgramacion.TEORIA)) {
            if (categoria.equals(ConstantesProgramacion.B1)){
                Programacion.validarTeoriaB1(contadorTeoria);
                Programacion.verificacionPrimerPagoB1(abono);
            } else if (categoria.equals(ConstantesProgramacion.C1)){
                Programacion.validarTeoriaC1(contadorTeoria);
                Programacion.verificacionPrimerPagoC1(abono);
            }
        } else if (clase.equals(ConstantesProgramacion.PRACTICA)) {
            if (categoria.equals(ConstantesProgramacion.B1)){
                Programacion.validarPracticaB1(contadorTeoria, contadorPractica);
                Programacion.verificacionSegundoPagoB1(abono);
            } else if (categoria.equals(ConstantesProgramacion.C1)){
                Programacion.validarPracticaC1(contadorTeoria, contadorPractica);
                Programacion.verificacionSegundoPagoC1(abono);
            }
        } else if (clase.equals(ConstantesProgramacion.REFUERZO)){
                Programacion.verificacionSegundoPagoC1(abono);
        } else {
            throw new ExcepcionInvalido(ConstantesProgramacion.MENSAJE_INVALIDO);
        }
    }

    public static void validarTeoriaB1(Long contadorTeoria) {
        if (contadorTeoria.equals(ConstantesProgramacion.PRIMER_REGISTRO) || contadorTeoria < ConstantesProgramacion.CLASESTEORIA_B1) {
            } else {
            throw new ExcepcionValidacionClase(ConstantesProgramacion.MENSAJE_CLASE);
            }
    }

    public static void validarTeoriaC1(Long contadorTeoria) {
        if (contadorTeoria.equals(ConstantesProgramacion.PRIMER_REGISTRO) || contadorTeoria < ConstantesProgramacion.CLASESTEORIA_C1) {
        } else {
            throw new ExcepcionValidacionClase(ConstantesProgramacion.MENSAJE_CLASE);
        }
    }

    public static void validarPracticaB1(Long contadorTeoria, Long contadorPractica) {
        if (contadorTeoria.equals(ConstantesProgramacion.CLASESTEORIA_B1)) {
            if (contadorPractica.equals(ConstantesProgramacion.PRIMER_REGISTRO) || contadorPractica < ConstantesProgramacion.CLASESPRACTICA_B1){
            } else {
                throw new ExcepcionValidacionClase(ConstantesProgramacion.MENSAJE_CLASE);
            }
        } else {
            throw new ExcepcionTeoria(ConstantesProgramacion.MENSAJE_TEORIA);
        }
    }

    public static void validarPracticaC1(Long contadorTeoria, Long contadorPractica) {
        if (contadorTeoria.equals(ConstantesProgramacion.CLASESTEORIA_C1)) {
            if (contadorPractica.equals(ConstantesProgramacion.PRIMER_REGISTRO)|| contadorPractica < ConstantesProgramacion.CLASESPRACTICA_C1){
            } else {
                throw new ExcepcionValidacionClase(ConstantesProgramacion.MENSAJE_CLASE);
            }
        } else {
            throw new ExcepcionTeoria(ConstantesProgramacion.MENSAJE_TEORIA);
        }
    }

    public static void disponibilidadInstructor(Long disponibilidad) {
        if (disponibilidad != 0){
            System.out.println(disponibilidad);

            System.out.println("diponibilidad");

            throw new ExcepcionInstructor(ConstantesProgramacion.MENSAJE_INSTRUCTOR);
        }
    }

    public static Date validacionFechaClasePractica(Date fecha, Long clase) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        Date fechaHabil = null;
        if (clase.equals(ConstantesProgramacion.TEORIA)) {
            fechaHabil = fecha;
        } else if (clase.equals(ConstantesProgramacion.PRACTICA) || clase.equals(ConstantesProgramacion.REFUERZO)) {
            if (!(dayOfWeek == 7 || dayOfWeek == 1)) {
                fechaHabil = fecha;
            }
        } else {
            throw new ExcepcionFecha(ConstantesProgramacion.MENSAJE_FECHA);
        }
        return fechaHabil;
    }

    public static void verificacionPrimerPagoB1(Double abono) {
        if (abono < ConstantesProgramacion.ABONO_B1) {
            System.out.println("verificacionPrimerPagoB1");
            throw new ExcepcionPago(ConstantesProgramacion.MENSAJE_PAGO);
        }
    }

    public static void verificacionPrimerPagoC1(Double abono) {
        if (abono < ConstantesProgramacion.ABONO_C1) {
            System.out.println("verificacionPrimerPagoC1");
            throw new ExcepcionPago(ConstantesProgramacion.MENSAJE_PAGO);
        }
    }

    public static void verificacionSegundoPagoB1(Double abono) {
        if (abono < ConstantesProgramacion.TOTAL_B1) {
            System.out.println("verificacionSegundoPagoB1");

            throw new ExcepcionPago(ConstantesProgramacion.MENSAJE_PAGO);
        }
    }

    public static void verificacionSegundoPagoC1(Double abono) {
        if (abono < ConstantesProgramacion.TOTAL_C1) {
            System.out.println("verificacionSegundoPagoC1");
            System.out.println(abono);

            throw new ExcepcionPago(ConstantesProgramacion.MENSAJE_PAGO);
        }
    }

}
