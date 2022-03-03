package com.heyiamej.bootcamp.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

import lombok.*;


@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, unique = true)
    private String documento;

    private String dataNascimento;

    @Column(nullable = true)
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Blog> blogs;

    @Column(nullable = true)
    @OneToMany(mappedBy = "pessoa_id", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Ponto> pontos;

    @Column(nullable = true)
    @OneToMany(mappedBy = "pessoa_id", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Pagamento> pagamentos;



}