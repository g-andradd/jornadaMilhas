package br.com.alura.jornadamilhas.controller;

import br.com.alura.jornadamilhas.dto.DestinoDto;
import br.com.alura.jornadamilhas.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
