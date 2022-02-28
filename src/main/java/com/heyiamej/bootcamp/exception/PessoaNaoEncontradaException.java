package com.heyiamej.bootcamp.exception;

public class PessoaNaoEncontradaException extends Exception {
    public PessoaNaoEncontradaException(Long id) {
        super(String.format("Pessoa com id %d não encontrada!", id));
    }
}
