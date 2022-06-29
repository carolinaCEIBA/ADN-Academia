package com.ceiba.aprendiz.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.aprendiz.puerto.repositorio.RepositorioAprendiz;
import com.ceiba.programacion.controlador.ComandoControladorProgramacion;
import com.ceiba.programacion.controlador.RespuestaProgramar;
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
class ComandoControladorAprendizTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioAprendiz repositorioAprendiz;

    @Test
    void creacionAprendizExitosa() throws Exception{
        var comandoAprendizTestDataBuilder = new ComandoAprendizTestDataBuilder().aprendizPorDefecto().build();

        var resultado = mocMvc.perform(post("/academia/aprendiz")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoAprendizTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaProgramar.class);
        var aprendizCreado = repositorioAprendiz.obtener(respuesta.getValor());

        Assertions.assertEquals(6l, aprendizCreado.getId());
        Assertions.assertEquals("Carolina", aprendizCreado.getNombre());
        Assertions.assertEquals("Fonseca", aprendizCreado.getApellido());
        Assertions.assertEquals("CC", aprendizCreado.getTipodoc());
        Assertions.assertEquals("1000791524", aprendizCreado.getDocumento());
        Assertions.assertEquals("Sanitas", aprendizCreado.getEps());
        Assertions.assertEquals("C1", aprendizCreado.getCategoria());
        Assertions.assertEquals(1500000, aprendizCreado.getValorcurso());
        Assertions.assertEquals(1500000, aprendizCreado.getAbono());
        Assertions.assertEquals(70000, aprendizCreado.getAdicional());

    }

}
