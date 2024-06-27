package br.com.octopus.viaCep.service;

import br.com.octopus.viaCep.exception.CepInvalidoException;
import br.com.octopus.viaCep.exception.CepNaoEncontradoException;
import br.com.octopus.viaCep.feign.EnderecoFeign;
import br.com.octopus.viaCep.model.EnderecoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EnderecoService {

    private final EnderecoFeign feign;

    public ResponseEntity<?> consultarCep(String cep) {
        cep = cep.replaceAll("\\D", "");

        try{
            if (cep.length() != 8) {
                throw new CepInvalidoException("Cep inválido: o número do cep deve conter 8 dígitos");
            }

            EnderecoResponse response = feign.buscarEnderecoCep(cep);

            if(response.cep() == null) {
                throw new CepNaoEncontradoException("Cep não encontrado");
            }

            return ResponseEntity.ok(response);

        } catch (CepInvalidoException | CepNaoEncontradoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
