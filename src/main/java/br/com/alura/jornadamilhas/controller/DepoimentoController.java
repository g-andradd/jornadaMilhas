package br.com.alura.jornadamilhas.controller;

import br.com.alura.jornadamilhas.dto.DepoimentoDto;
import br.com.alura.jornadamilhas.service.DepoimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
