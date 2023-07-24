package br.com.alura.jornadamilhas.controller;

import br.com.alura.jornadamilhas.dto.DestinoDto;
import br.com.alura.jornadamilhas.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/destinos")
@CrossOrigin
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    private ResponseEntity<List<DestinoDto>> listar() {
        List<DestinoDto> destinos = destinoService.listar();

        return ResponseEntity.ok(destinos);
    }

}
