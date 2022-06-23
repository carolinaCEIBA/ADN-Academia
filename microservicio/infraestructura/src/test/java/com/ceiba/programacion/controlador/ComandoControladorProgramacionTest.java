package com.ceiba.programacion.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.programacion.puerto.repositorio.RepositorioProgramacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
        Date fecha = sdf.parse("2021/06/18");
        Assertions.assertEquals(1l, programacionGuardada.getIdprogramacion());
        Assertions.assertEquals(1l, programacionGuardada.getClase());
        Assertions.assertEquals(2l, programacionGuardada.getAprendiz());
        Assertions.assertEquals(1l, programacionGuardada.getInstructor());
        Assertions.assertEquals(fecha, programacionGuardada.getFecha());
        Assertions.assertEquals("03:00 pm", programacionGuardada.getHora());
        Assertions.assertEquals("NA", programacionGuardada.getAsistencia());

    }

}
