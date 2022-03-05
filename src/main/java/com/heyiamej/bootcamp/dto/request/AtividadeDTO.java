package com.heyiamej.bootcamp.dto.request;

import com.heyiamej.bootcamp.entity.Profissao;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeDTO {

    private Long id;

    private String nome;

    private String descricao;

    private Integer nivel;

    private Integer profissao_id;

}