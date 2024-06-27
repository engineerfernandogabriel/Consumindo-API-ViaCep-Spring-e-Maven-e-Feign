package br.com.octopus.viaCep.exception;

public class CepNaoEncontradoException extends RuntimeException {

    public CepNaoEncontradoException (String message) {
        super(message);
    }
}

