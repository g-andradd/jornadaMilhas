package br.com.alura.jornadamilhas.controller;

import br.com.alura.jornadamilhas.dto.DepoimentoDto;
import br.com.alura.jornadamilhas.form.DepoimentoForm;
import br.com.alura.jornadamilhas.service.DepoimentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class DepoimentoController {

    private final DepoimentoService depoimentoService;

    public DepoimentoController(DepoimentoService depoimentoService) {
        this.depoimentoService = depoimentoService;
    }

    @GetMapping("/depoimentos")
    public ResponseEntity<List<DepoimentoDto>> buscarTodos() {
        return ResponseEntity.ok(depoimentoService.buscarTodos());
    }

    @GetMapping("/depoimentos-home")
    public ResponseEntity<List<DepoimentoDto>> listarHome() {
        return ResponseEntity.ok(depoimentoService.listarHome(3));
    }

    @PostMapping("/depoimentos")
    public ResponseEntity<DepoimentoDto> inserir(@RequestBody @Valid DepoimentoForm form, UriComponentsBuilder uriBuilder) {
        DepoimentoDto depoimentoDto = depoimentoService.inserir(form);

        URI uri = uriBuilder.path("/depoimentos/{id}").buildAndExpand(depoimentoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(depoimentoDto);
    }

    @PutMapping("/depoimentos/{id}")
    public ResponseEntity<DepoimentoDto> atualizar(@PathVariable String id, @RequestBody DepoimentoForm form) {
        DepoimentoDto depoimentoDto = depoimentoService.atualizar(id, form);
        return ResponseEntity.ok(depoimentoDto);
    }

    @DeleteMapping("/depoimentos/{id}")
    public ResponseEntity<Void> remover(@PathVariable String id) {
        depoimentoService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
