package com.heyiamej.bootcamp.dto.request;

import com.heyiamej.bootcamp.entity.Atividade;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfissaoDTO {

    private Long id;

    private String nome;

    private String descricao;

    private List<Atividade> atividade;
}
