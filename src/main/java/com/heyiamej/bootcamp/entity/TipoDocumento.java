package com.heyiamej.bootcamp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDocumento {
    FISICA("CPF"),
    JURIDICA("CNPJ");

    private final String descricao;

}
