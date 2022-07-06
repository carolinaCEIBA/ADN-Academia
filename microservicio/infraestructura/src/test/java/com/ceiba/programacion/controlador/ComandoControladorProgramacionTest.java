package com.ceiba.programacion.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.aprendiz.controlador.ComandoAprendizTestDataBuilder;
import com.ceiba.aprendiz.modelo.entidad.Aprendiz;
import com.ceiba.aprendiz.puerto.repositorio.RepositorioAprendiz;
import com.ceiba.factura.comando.ComandoSolicitudRegistrarAp;
import com.ceiba.programacion.modelo.entidad.Programacion;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;
import com.ceiba.programacion.servicio.ServicioProgramar;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorProgramacion.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorProgramacionTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioProgramacion repositorioProgramacion;


    @Test
    void crearProgramacionExitosa() throws Exception{
        var comandoProgramarTestDataBuilder = new ComandoProgramarTestDataBuilder().programacionPorDefecto().build();
        var resultado = mocMvc.perform(post("/academia/programacion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProgramarTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        var respuesta = objectMapper.readValue(jsonResult, RespuestaProgramar.class);
        var programacionGuardada = repositorioProgramacion.obtener(respuesta.getValor());


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date fecha = sdf.parse("2021/06/20");
        Assertions.assertEquals(2l, programacionGuardada.getIdprogramacion());
        Assertions.assertEquals(1l, programacionGuardada.getClase());
        Assertions.assertEquals(3l, programacionGuardada.getAprendiz());
        Assertions.assertEquals(2l, programacionGuardada.getInstructor());
        Assertions.assertEquals(fecha, programacionGuardada.getFecha());
        Assertions.assertEquals("04:00 pm", programacionGuardada.getHora());
        Assertions.assertEquals("No", programacionGuardada.getAsistencia());

    }

}
