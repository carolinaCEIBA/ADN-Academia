package com.ceiba.aprendiz.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SolicitudRegistrarAp {
    private Long id;
    private String nombre;
    private String apellido;
    private String tipodoc;
    private String documento;
    private String eps;
    private String categoria;
    private Long inasistencia;
    private double valorcurso;
    private double adicional;
    private Long refuerzo;

}
