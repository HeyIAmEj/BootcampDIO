package com.heyiamej.bootcamp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {
    FIXO("Fixo"),
    CELULAR("Celular"),
    COMERCIAL("Comercial");

    private final String descricao;

}
