package com.ceiba.programacion.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;

import java.util.Calendar;
import java.util.Date;


public class Programacion {
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

    private RepositorioProgramacion repositorioProgramacion;

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
        ValidadorArgumento.validarObligatorio(solicitudProgramar.getIdprogramacion(), "El id para la programación es obligatorio");
        ValidadorArgumento.validarObligatorio(solicitudProgramar.getClase(), "El tipo de clase es requerido para programar");
        ValidadorArgumento.validarObligatorio(solicitudProgramar.getAprendiz(), "El aprendiz es requerido para programar");
        ValidadorArgumento.validarObligatorio(solicitudProgramar.getInstructor(), "El instructor es requerido para programar");
        ValidadorArgumento.validarObligatorio(solicitudProgramar.getFecha(), "La fecha es obligatoria para programar la clase");
        ValidadorArgumento.validarObligatorio(solicitudProgramar.getHora(), "La hora es obligatoria para programar la clase");

        return new Programacion(solicitudProgramar.getIdprogramacion(), solicitudProgramar.getClase(), solicitudProgramar.getAprendiz(), solicitudProgramar.getInstructor(), solicitudProgramar.getFecha(), solicitudProgramar.getHora(), solicitudProgramar.getAsistencia());
    }

    public static Programacion reconstruir(Long idprogramacion, Long clase, Long aprendiz, Long instructor, Date fecha, String hora, String asistencia) {
        ValidadorArgumento.validarObligatorio(idprogramacion, "El id para la programación es obligatorio");
        ValidadorArgumento.validarObligatorio(clase, "El tipo de clase es requerido para programar");
        ValidadorArgumento.validarObligatorio(aprendiz, "El aprendiz es requerido para programar");
        ValidadorArgumento.validarObligatorio(instructor, "El instructor es requerido para programar");
        ValidadorArgumento.validarObligatorio(fecha, "La fecha es obligatoria para programar la clase");
        ValidadorArgumento.validarObligatorio(hora, "La hora es obligatoria para programar la clase");

        return new Programacion(idprogramacion, clase, aprendiz, instructor, fecha, hora, asistencia);
    }

    public static void orquestadorClase(Long contadorTeoria, Long contadorPractica, Long contadorRefuerzo, Long clase, String categoria) {
        if (clase == 1) {
            Programacion.validarTeoria(contadorTeoria, categoria);
        } else if (clase == 2) {
            Programacion.validarPractica(contadorTeoria, contadorPractica, categoria);
        } else if (clase == 3) {
            //Programacion.validarPractica(contadorTeoria, contadorPractica, contadorRefuerzo, categoria);
        } else {
            System.out.println("No corresponde");
        }
    }

    public static void validarTeoria(Long contadorTeoria, String categoria) {
        if (contadorTeoria == 0) {
            System.out.println("Primer registro");
        } else {
            if (categoria.equals("B1") && (contadorTeoria < 25)) {
            } else if (categoria.equals("C1") && (contadorTeoria < 30)) {
            } else {
                System.out.println("No puede agendar mas clases teoricas");
            }
        }

    }

    public static void validarPractica(Long contadorTeoria, Long contadorPractica, String categoria) {
        if (contadorPractica == 0) {
            System.out.println("Primer registro practico");
        } else if (contadorPractica >=1){
            if (categoria.equals("B1") && contadorTeoria == 25 && contadorPractica < 25) {
            } else if (categoria.equals("C1") && contadorTeoria == 30 && contadorPractica < 30) {
            }
        } else {
            System.out.println("No puede agendar mas clases practicas");
        }

    }

    public static void disponibilidadInstructor(Long disponibilidad) {
        if (disponibilidad != 0) {
            System.out.println("instructor no tiene disponibilidad");
        } else {
            System.out.println("continuar");
        }
    }

    public static Date validacionFechaClasePractica(Date fecha, Long clase) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        Date fechaHabil = null;
        if (clase == 2 || clase == 3) {
            if (!(dayOfWeek == 6 || dayOfWeek == 7)) {
                fechaHabil = fecha;
            } else {
                System.out.println("La clase no puede ser programada este dia");
            }
        } else if (clase == 1) {
            fechaHabil = fecha;
        }
        return fechaHabil;
    }

    public static void verificacionPago(Double abono, Long clase, String categoria) {
        if (categoria.equals("B1")) {
            if (clase == 1 && abono == 600000) {
                System.out.println("Puede continuar");
            } else if ((clase == 2 || clase == 3) && abono == 1200000) {
                System.out.println("Puede continuar");
            }
        } else if (categoria.equals("C1")) {
            if (clase == 1 && abono == 750000) {
                System.out.println("Puede continuar");
            } else if ((clase == 2 || clase == 3) && abono == 1500000) {
                System.out.println("Puede continuar");
            } else {
                System.out.println("El proceso no es valido");
            }

        }
    }
}
