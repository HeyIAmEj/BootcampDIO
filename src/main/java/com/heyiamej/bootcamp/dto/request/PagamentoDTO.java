package com.heyiamej.bootcamp.dto.request;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {
    private Long id;

    @NotEmpty
    private String data;

    private Integer isAdiantado;

    private Integer isAtrasado;

    @Column(nullable = false)
    private Double valor;

    private Long pessoa_id;
}
