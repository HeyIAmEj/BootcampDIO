package com.heyiamej.bootcamp.dto.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.heyiamej.bootcamp.entity.Pagamento;
import com.heyiamej.bootcamp.entity.Ponto;
import com.heyiamej.bootcamp.entity.Profissao;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String nome;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String sobrenome;

    @NotEmpty
    //@CPF
    private String documento;
    private String dataNascimento;

    //private Integer profissao;
    private Profissao profissao;
    private Integer nivel;
   // private List<AtividadesDesenvolvidas> atividadesDesenvolvidas;

    @Valid
    private List<BlogDTO> blogs;

    private List<Ponto> pontos;

    private List<Pagamento> pagamentos;

}