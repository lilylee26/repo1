package com.mx.Client;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestMockBasicController {

    @Autowired
    private MockMvc mock;


    @Test
    void testMockSaludo() throws Exception {

        this.mock.perform(get("/")) // simula la petición http
            .andDo(print()) // imprime resultados en consola
            .andExpect(status().isOk()) // verifica que sea 200 OK
            .andExpect(content().string(containsString("Hola mundo"))); // verifica respuesta
    }
}

