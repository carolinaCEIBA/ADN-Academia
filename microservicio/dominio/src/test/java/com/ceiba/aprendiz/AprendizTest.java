package com.ceiba.aprendiz;

import com.ceiba.BasePrueba;
import com.ceiba.aprendiz.modelo.entidad.Aprendiz;
import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.programacion.modelo.entidad.Programacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

public class AprendizTest {

        @Test
        void deberiaCrearAprendizExitoso() {

            var aprendiz = new AprendizTestDataBuilder().conAprendizPorDefecto()
                    .crear();

            Assertions.assertEquals(5l, aprendiz.getId());
            Assertions.assertEquals("Carolina", aprendiz.getNombre());
            Assertions.assertEquals("Fonseca", aprendiz.getApellido());
            Assertions.assertEquals("CC", aprendiz.getTipodoc());
            Assertions.assertEquals("1000791524", aprendiz.getDocumento());
            Assertions.assertEquals("Sanitas", aprendiz.getEps());
            Assertions.assertEquals("C1", aprendiz.getCategoria());
            Assertions.assertEquals(1500000, aprendiz.getValorcurso());
            Assertions.assertEquals(1500000, aprendiz.getAbono());
            Assertions.assertEquals(70000, aprendiz.getAdicional());
        }

        @Test
        void deberiaReconstruirAprendizExitoso() {

            var aprendiz = new AprendizTestDataBuilder().conAprendizPorDefecto()
                    .reconstruir();

            Assertions.assertEquals(5l, aprendiz.getId());
            Assertions.assertEquals("Carolina", aprendiz.getNombre());
            Assertions.assertEquals("Fonseca", aprendiz.getApellido());
            Assertions.assertEquals("CC", aprendiz.getTipodoc());
            Assertions.assertEquals("1000791524", aprendiz.getDocumento());
            Assertions.assertEquals("Sanitas", aprendiz.getEps());
            Assertions.assertEquals("C1", aprendiz.getCategoria());
            Assertions.assertEquals(1500000, aprendiz.getValorcurso());
            Assertions.assertEquals(1500000, aprendiz.getAbono());
            Assertions.assertEquals(70000, aprendiz.getAdicional());
        }

        @Test
        void errorNombreNulo() {
            BasePrueba.assertThrows(() -> new AprendizTestDataBuilder().conAprendizPorDefecto()
                            .conNombre(null).crear(),
                    ExcepcionValorObligatorio.class,
                    "El nombre del aprendiz es obligatorio para el registro");
        }

        @Test
        void errorApellidoNulo(){
            BasePrueba.assertThrows(() -> new AprendizTestDataBuilder().conAprendizPorDefecto()
                    .conApellido(null).crear(),
                    ExcepcionValorObligatorio.class,
                    "El apellido del aprendiz es obligatorio para el registro");
        }

        @Test
        void errorTipoNulo(){
            BasePrueba.assertThrows(() -> new AprendizTestDataBuilder().conAprendizPorDefecto()
                            .conTipoDoc(null).crear(),
                    ExcepcionValorObligatorio.class,
                    "El tipo de documento del aprendiz es obligatorio para el registro");
        }

        @Test
        void errorDocumentoNulo(){
            BasePrueba.assertThrows(() -> new AprendizTestDataBuilder().conAprendizPorDefecto()
                            .conDocumento(null).crear(),
                    ExcepcionValorObligatorio.class,
                    "El documento del aprendiz es obligatorio para el registro");
        }

        @Test
        void errorCategoriaNulo(){
            BasePrueba.assertThrows(() -> new AprendizTestDataBuilder().conAprendizPorDefecto()
                            .conCategoria(null).crear(),
                    ExcepcionValorObligatorio.class,
                    "La categoria es obligatoria para el registro");
        }

        @Test
        void errorNombreNuloReconstruir() {
            BasePrueba.assertThrows(() -> new AprendizTestDataBuilder().conAprendizPorDefecto()
                            .conNombre(null).reconstruir(),
                    ExcepcionValorObligatorio.class,
                    "El nombre del aprendiz es obligatorio para el registro");
        }

        @Test
        void errorApellidoNuloReconstruir(){
            BasePrueba.assertThrows(() -> new AprendizTestDataBuilder().conAprendizPorDefecto()
                            .conApellido(null).reconstruir(),
                    ExcepcionValorObligatorio.class,
                    "El apellido del aprendiz es obligatorio para el registro");
        }

        @Test
        void errorTipoNuloReconstruir(){
            BasePrueba.assertThrows(() -> new AprendizTestDataBuilder().conAprendizPorDefecto()
                            .conTipoDoc(null).reconstruir(),
                    ExcepcionValorObligatorio.class,
                    "El tipo de documento del aprendiz es obligatorio para el registro");
        }

        @Test
        void errorDocumentoNuloReconstruir(){
            BasePrueba.assertThrows(() -> new AprendizTestDataBuilder().conAprendizPorDefecto()
                            .conDocumento(null).reconstruir(),
                    ExcepcionValorObligatorio.class,
                    "El documento del aprendiz es obligatorio para el registro");
        }

        @Test
        void errorCategoriaNuloReconstruir(){
            BasePrueba.assertThrows(() -> new AprendizTestDataBuilder().conAprendizPorDefecto()
                            .conCategoria(null).reconstruir(),
                    ExcepcionValorObligatorio.class,
                    "La categoria es obligatoria para el registro");
        }

}





