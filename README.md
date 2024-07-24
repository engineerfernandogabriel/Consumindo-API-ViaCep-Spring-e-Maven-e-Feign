# Consumindo API ViaCep - Spring, Feign e Maven.

Este serviço é uma integração com a API da ViaCep usando o Spring, Feign e Maven.

O serviço conta com:
- Tratamento das exceções (CEP inválido, CEP não encontrado);
- Tratamento da entrada do cep - a API só aceita 8 caracteres e tem de ser dígitos;
- Tratamento da entrada das cidades e nome da Rua - a API exige conter no mínimo 3 digitos para ambos os parâmetros.

&nbsp;
# Como rodar e testar o software
### OPÇÃO 1
&emsp;Run da própria IDE

### OPÇÃO 2

    $ mvn spring-boot:run

&emsp;** _Para parar o serviço usar o CTRL + C_

### OPÇÃO 3

    $ mvn package

    $ java -jar target/viaCep-0.0.1-SNAPSHOT.jar

&emsp;** _Para parar o serviço usar o CTRL + C_

### OPÇÃO 4

    $  mvn exmvn exec:java -Dexec.mainClass="br.com.octopus.viaCep.ViaCepApplication"


&emsp;** _Para parar o serviço usar o CTRL + C_


&nbsp;
--
### Documentação swagger

    $ http://localhost:8080/swagger-ui/index.html
---

&nbsp;
# GET - consultaEndereco _(informações do cep)_

  exibe as informações correspondentes ao cep informado;

Controladora

    http://localhost:8080/cep/consultaEndereco/{cep}

EXEMPLO:

Request

    GET     localhost:8080/cep/consulta/81280-340

Response

    {
      "cep": "81280-340",
	  "logradouro": "Rua Deputado Heitor Alencar Furtado",
	  "bairro": "Cidade Industrial",
	  "localidade": "Curitiba",
	  "uf": "PR",
	  "ibge": "4106902",
	  "gia": "",
	  "ddd": "41",
	  "siafi": "7535"   
    }

&nbsp;
# GET - consultaCep _(descobrir o cep)_

exibe as informações correspondentes ao estado, cidade e nome da Rua informados;

Controladora

    http://localhost:8080/cep/consultaCep/

EXEMPLO:

Request

    GET     localhost:8080/cep/consultaCep?uf=PR&cidade=Curitiba&nomeDaRua=Deputado%20Heitor%20Alencar%20Furtado

Response

_retorna uma lista com todas as correspondências do nome pesquisado_

    [
        {
            "cep": "80740-060",
            "logradouro": "Rua Deputado Heitor Alencar Furtado",
            "bairro": "Campina do Siqueira",
            "localidade": "Curitiba",
            "uf": "PR",
            "ibge": "4106902",
            "gia": "",
            "ddd": "41",
            "siafi": "7535"
        },
        {
            "cep": "81200-959",
            "logradouro": "Rua Deputado Heitor Alencar Furtado",
            "bairro": "Mossunguê",
            "localidade": "Curitiba",
            "uf": "PR",
            "ibge": "4106902",
            "gia": "",
            "ddd": "41",
            "siafi": "7535"
        },
        {
            "cep": "81200-981",
            "logradouro": "Rua Deputado Heitor Alencar Furtado",
            "bairro": "Mossunguê",
            "localidade": "Curitiba",
            "uf": "PR",
            "ibge": "4106902",
            "gia": "",
            "ddd": "41",
            "siafi": "7535"
        },
        {
            "cep": "81200-110",
            "logradouro": "Rua Deputado Heitor Alencar Furtado",
            "bairro": "Mossunguê",
            "localidade": "Curitiba",
            "uf": "PR",
            "ibge": "4106902",
            "gia": "",
            "ddd": "41",
            "siafi": "7535"
        },
        {
            "cep": "81280-340",
            "logradouro": "Rua Deputado Heitor Alencar Furtado",
            "bairro": "Cidade Industrial",
            "localidade": "Curitiba",
            "uf": "PR",
            "ibge": "4106902",
            "gia": "",
            "ddd": "41",
            "siafi": "7535"
        },
        {
            "cep": "81200-528",
            "logradouro": "Rua Deputado Heitor Alencar Furtado",
            "bairro": "Campo Comprido",
            "localidade": "Curitiba",
            "uf": "PR",
            "ibge": "4106902",
            "gia": "",
            "ddd": "41",
            "siafi": "7535"
        }
    ]
