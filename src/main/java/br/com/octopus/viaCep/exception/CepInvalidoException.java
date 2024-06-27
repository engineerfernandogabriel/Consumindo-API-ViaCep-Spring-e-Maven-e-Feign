package br.com.octopus.viaCep.exception;

public class CepInvalidoException extends RuntimeException {

    public CepInvalidoException(String message) {
        super(message);
    }
}