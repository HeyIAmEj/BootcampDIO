package com.heyiamej.bootcamp.exception;

public class ProfissaoNaoEncontradaException extends Exception {
    public ProfissaoNaoEncontradaException(Long id) {
        super(String.format("Profissão com id %d não encontrada!", id));
    }
}
