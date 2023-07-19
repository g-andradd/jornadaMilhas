package br.com.alura.jornadamilhas.controller;

import br.com.alura.jornadamilhas.dto.DepoimentoDto;
import br.com.alura.jornadamilhas.form.DepoimentoForm;
import br.com.alura.jornadamilhas.service.DepoimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<List<DepoimentoDto>> listar() {

        return ResponseEntity.ok().body(depoimentoService.listar());
    }

    @PostMapping
    public ResponseEntity<DepoimentoDto> inserir(@RequestBody @Valid DepoimentoForm form, UriComponentsBuilder uriBuilder) {
        DepoimentoDto depoimentoDto = depoimentoService.inserir(form);

        URI uri = uriBuilder.path("/depoimentos/{id}").buildAndExpand(depoimentoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(depoimentoDto);
    }

    @PutMapping( "/{id}")
    public ResponseEntity<DepoimentoDto> atualizar(@PathVariable Long id, @RequestBody DepoimentoForm form) {
        DepoimentoDto depoimentoDto = depoimentoService.atualizar(id, form);
        return ResponseEntity.ok().body(depoimentoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        depoimentoService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
