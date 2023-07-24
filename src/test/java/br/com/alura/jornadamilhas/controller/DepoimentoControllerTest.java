package br.com.alura.jornadamilhas.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(classes = DepoimentoController.class)
@AutoConfigureMockMvc
class DepoimentoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void listar_cenario1() {


    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informações estao invalidas")
    void inserir_cenario1() throws Exception {
        var response = mvc.perform(get("/depomentos"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void atualizar() {
    }

    @Test
    void deletar() {
    }
}