package com.ceiba.programacion.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ResumenProgramacionDTO {
    private String clase;
    private String aprendiz;
    private String instructor;
    private Date fecha;
    private String hora;
    private String asistencia;

}
