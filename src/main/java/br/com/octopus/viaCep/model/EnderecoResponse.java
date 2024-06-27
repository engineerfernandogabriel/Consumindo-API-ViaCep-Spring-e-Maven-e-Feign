package br.com.octopus.viaCep.model;

public record EnderecoResponse (String cep, String logradouro, String bairro, String localidade, String uf, String ibge,
                                String gia, String ddd, String siafi) {

}
