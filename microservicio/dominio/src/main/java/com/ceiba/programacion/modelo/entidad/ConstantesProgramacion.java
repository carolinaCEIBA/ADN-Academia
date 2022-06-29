package com.ceiba.programacion.modelo.entidad;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConstantesProgramacion {
    public static final String C1 = "C1";
    public static final String B1 = "B1";
    public static final Long TEORIA = 1l;
    public static final Long PRACTICA = 2l;
    public static final Long REFUERZO = 2l;

    public static final Long PRIMER_REGISTRO = 0l;
    public static final Long CLASESTEORIA_B1 = 25l;
    public static final Long CLASESPRACTICA_B1 = 20l;
    public static final Long CLASESTEORIA_C1 = 30l;
    public static final Long CLASESPRACTICA_C1 = 30l;
    public static final Double ABONO_B1 = 600000.0;
    public static final Double ABONO_C1 = 750000.0;
    public static final Double TOTAL_B1 = 1200000.0;
    public static final Double TOTAL_C1 = 1500000.0;
    public static final String MENSAJE_PAGO = "Debe cancelar el monto requerido para programar";
    public static final String MENSAJE_FECHA = "Esta clase no puede ser programada sabado/domingo";
    public static final String MENSAJE_INSTRUCTOR = "EL instructor no tiene disponibilidad";
    public static final String MENSAJE_TEORIA = "Debe terminar clases teoricas";
    public static final String MENSAJE_CLASE = "No cumple con los requisitos para programar esta clase";
    public static final String MENSAJE_INVALIDO = "Proceso invalido";

}
