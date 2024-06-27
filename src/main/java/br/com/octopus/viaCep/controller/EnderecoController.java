package br.com.octopus.viaCep.controller;

import br.com.octopus.viaCep.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/cep")
@RestController
public class EnderecoController {

    private final EnderecoService service;

    @GetMapping("/consulta/{cep}")
    public ResponseEntity<?> consultaCep(@PathVariable String cep) {
        return service.consultarCep(cep);
    }
}
