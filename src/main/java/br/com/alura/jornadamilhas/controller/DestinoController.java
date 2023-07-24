package br.com.alura.jornadamilhas.controller;

import br.com.alura.jornadamilhas.dto.DestinoDto;
import br.com.alura.jornadamilhas.form.DestinoForm;
import br.com.alura.jornadamilhas.service.DestinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/destinos")
@CrossOrigin
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @GetMapping
    public ResponseEntity<List<DestinoDto>> buscarTodos() {
        List<DestinoDto> destinoDtoList = destinoService.buscarTodos();
        return ResponseEntity.ok(destinoDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinoDto> buscarPorId(@PathVariable String id) {
        DestinoDto destinoDto = destinoService.buscarPorId(id);
        return ResponseEntity.ok(destinoDto);
    }

    @PostMapping
    public ResponseEntity<DestinoDto> inserir(@RequestBody @Valid DestinoForm form, UriComponentsBuilder uriBuilder) {
        DestinoDto destinoDto = destinoService.inserir(form);

        URI uri = uriBuilder.path("/destinos/{id}").buildAndExpand(destinoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(destinoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DestinoDto> atualizar(@PathVariable String id, @RequestBody @Valid DestinoForm form) {
        DestinoDto destinoDto = destinoService.atualizar(id, form);
        return ResponseEntity.ok(destinoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable String id) {
        destinoService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
