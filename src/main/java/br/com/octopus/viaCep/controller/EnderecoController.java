package br.com.octopus.viaCep.controller;

import br.com.octopus.viaCep.model.EnderecoResponse;
import br.com.octopus.viaCep.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/cep")
@RestController
@Tag(name = "endereco controller")
public class EnderecoController {

    private final EnderecoService service;

    @Operation(summary = "consultar endereço pelo cep", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Consulta Ok", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = EnderecoResponse.class))}),
        @ApiResponse(responseCode = "400", description = "Parâmetros Inválidos"),
    })
    @GetMapping("/consultaEndereco/{cep}")
    public ResponseEntity<?> consultaEndereco(@PathVariable String cep) {
        return service.consultaEndereco(cep);
    }

    @Operation(summary = "consultar cep pelo endereço", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta Ok", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = EnderecoResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Parâmetros Inválidos"),
    })
    @GetMapping("/consultaCep")
    public ResponseEntity<?> consultaCep(@RequestParam String uf, @RequestParam String cidade, @RequestParam String nomeDaRua){
        return service.consultaCep(uf, cidade, nomeDaRua);
    }

}
