package br.com.octopus.viaCep.controller;

import br.com.octopus.viaCep.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
