package br.com.octopus.viaCep.feign;

import br.com.octopus.viaCep.model.EnderecoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface EnderecoFeign {

    @GetMapping("{cep}/json")
    EnderecoResponse buscarEnderecoPeloCep(@PathVariable("cep") String cep);

    @GetMapping("{uf}/{cidade}/{nomeDaRua}/json")
    List<EnderecoResponse> buscarCepPeloEndereco(@PathVariable("uf") String uf, @PathVariable("cidade") String cidade, @PathVariable("nomeDaRua") String nomeDaRua);
}
