package com.heyiamej.bootcamp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private Integer nivel;

    @JoinColumn(name = "id")
    private Integer profissao_id;
}
