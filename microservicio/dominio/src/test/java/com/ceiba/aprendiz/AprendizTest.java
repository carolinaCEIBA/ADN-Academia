package com.ceiba.aprendiz;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AprendizTest {

        @Test
        void deberiaCrearAprndizExitoso() {

            var aprendiz = new AprendizTestDataBuilder()
                    .conId(1l)
                    .conNombre("Carolina").conApellido("Fonseca").conTipoDoc("CC")
                    .conDocumento("1000791524").conEps("Sanitas").conCategoria("C1")
                    .conInasistencia(1l).conValorCurso(1450000).conAdicional(70000)
                    .conRefuerzo(2l).crear();

            Assertions.assertEquals(1l, aprendiz.getId());
            Assertions.assertEquals("Carolina", aprendiz.getNombre());
            Assertions.assertEquals("Fonseca", aprendiz.getApellido());
            Assertions.assertEquals("CC", aprendiz.getTipodoc());
            Assertions.assertEquals("1000791524", aprendiz.getDocumento());
            Assertions.assertEquals("Sanitas", aprendiz.getEps());
            Assertions.assertEquals("C1", aprendiz.getCategoria());
            Assertions.assertEquals(1450000, aprendiz.getValorcurso());
            Assertions.assertEquals(750000, aprendiz.getAbono());
            Assertions.assertEquals(70000, aprendiz.getAdicional());
        }

        @Test
        void errorNombreNulo() {
            BasePrueba.assertThrows(() -> new AprendizTestDataBuilder()
                            .conNombre(null).crear(),
                    ExcepcionValorObligatorio.class,
                    "El nombre del aprendiz es obligatorio para el registro");
        }

        /**@Test
        void errorDocumentoNulo() {
            BasePrueba.assertThrows(() -> new AprendizTestDataBuilder()
                    .conDocumento(null).crear(),
                    ExcepcionValorObligatorio.class,
                    "El documento del aprendiz el obligatorio para el registro");
        }**/

}





