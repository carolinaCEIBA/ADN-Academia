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


    /**@Test
    void crearFacturaExitosa() throws Exception {
        var comandoFacturarTestDataBuilder = new ComandoProgramarTestDataBuilder().crearPorDefecto().build();

        var resultado = mocMvc.perform(post("/factura")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoFacturarTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaFacturar.class);

        //var facturaGuardada = repositorioProgramacion

    }**/


}
