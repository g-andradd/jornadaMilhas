package br.com.alura.jornadamilhas.controller;

import br.com.alura.jornadamilhas.dto.DepoimentoDto;
import br.com.alura.jornadamilhas.form.DepoimentoForm;
import br.com.alura.jornadamilhas.service.DepoimentoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class DepoimentoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DepoimentoForm> formJson;

    @Autowired
    private JacksonTester<DepoimentoDto> dtoJson;

    @MockBean
    private DepoimentoService depoimentoService;

    @Test
    void listar_cenario1() {
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    void inserir_cenario1() throws Exception {
        var response = mvc.perform(post("/depoimentos"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes validas")
    void inserir_cenario2() throws Exception {
        var mockDepoimentoDto = new DepoimentoDto(
                null,
                "imagem1",
                "O site onde comprei a melhor viagem da minha vida",
                "Gabriel Almeida"
        );
        when(depoimentoService.inserir(any())).thenReturn(mockDepoimentoDto);

        var response = mvc
                .perform(
                        post("/depoimentos")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(formJson.write(
                                        new DepoimentoForm(
                                                "imagem1",
                                                "O site onde comprei a melhor viagem da minha vida",
                                                "Gabriel Almeida"
                                        )
                                ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

        var jsonEsperado = dtoJson.write(
                mockDepoimentoDto
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

    @Test
    void atualizar() {
    }

    @Test
    void deletar() {
    }
}