package br.com.octopus.viaCep.service;

import br.com.octopus.viaCep.exception.CepInvalidoException;
import br.com.octopus.viaCep.exception.CidadeEnderecoInvalidoException;
import br.com.octopus.viaCep.feign.EnderecoFeign;
import br.com.octopus.viaCep.model.EnderecoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EnderecoService {

    private final EnderecoFeign feign;

    public ResponseEntity<?> consultaEndereco(String cep) {
        cep = cep.replaceAll("\\D", "");

        try{
            if (cep.length() != 8) {
                throw new CepInvalidoException("Cep inválido: o número do cep deve conter 8 dígitos");
            }

            EnderecoResponse response = feign.buscarEnderecoPeloCep(cep);

            if(response.cep() == null) {
                return ResponseEntity.ok("Cep não encontrado");
            }

            return ResponseEntity.ok(response);

        } catch (CepInvalidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity<?> consultaCep(String uf, String cidade, String nomeDaRua) {
        cidade = formatterString(cidade);
        nomeDaRua = formatterString(nomeDaRua);

        try {
            if(cidade.length() < 3) {
                throw new CidadeEnderecoInvalidoException("Cidade inválida: o nome da cidade deve conter no mínimo 3 caracteres");
            }

            if(nomeDaRua.length() < 3) {
                throw new CidadeEnderecoInvalidoException("Logradouro inválido: o nome da rua (logradouro) deve conter no mínimo 3 caracteres");
            }

            List<EnderecoResponse> response = feign.buscarCepPeloEndereco(uf, cidade, nomeDaRua);

            if (response.isEmpty()) {
                return ResponseEntity.ok("Endereço não encontrado");
            }
            return ResponseEntity.ok(response);

        } catch (CidadeEnderecoInvalidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public String formatterString (String word) {
        return Normalizer.normalize(word, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^\\w\\s]","")
                .replaceAll("\\s+", " ")
                .trim();
    }

}
