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

    @GetMapping("/consultaEndereco/{cep}")
    public ResponseEntity<?> consultaEndereco(@PathVariable String cep) {
        return service.consultaEndereco(cep);
    }

    @GetMapping("/consultaCep")
    public ResponseEntity<?> consultaCep(@RequestParam String uf, @RequestParam String cidade, @RequestParam String nomeDaRua){
        return service.consultaCep(uf, cidade, nomeDaRua);
    }

}
