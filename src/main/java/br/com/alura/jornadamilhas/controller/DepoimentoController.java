package br.com.alura.jornadamilhas.controller;

import br.com.alura.jornadamilhas.dto.DepoimentoDto;
import br.com.alura.jornadamilhas.form.DepoimentoForm;
import br.com.alura.jornadamilhas.service.DepoimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/depoimentos")
@CrossOrigin
public class DepoimentoController {

    private final DepoimentoService depoimentoService;

    public DepoimentoController(DepoimentoService depoimentoService) {
        this.depoimentoService = depoimentoService;
    }

    public ResponseEntity<List<DepoimentoDto>> listar() {

        return ResponseEntity.ok().body(depoimentoService.listar());
    }

    public ResponseEntity<DepoimentoDto> inserir(@RequestBody @Valid DepoimentoForm form, UriComponentsBuilder uriBuilder) {
        DepoimentoDto depoimentoDto = depoimentoService.inserir(form);

        URI uri = uriBuilder.path("/depoimentos/{id}").buildAndExpand(depoimentoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(depoimentoDto);
    }

}
