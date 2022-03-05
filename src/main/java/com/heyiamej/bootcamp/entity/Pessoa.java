package com.heyiamej.bootcamp.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(nullable = false)
    private String documento;

    @Column
    @Valid
    private LocalDate dataNascimento;

   /* @Column
    private Integer profissao;*/

    @Column
    private Integer nivel;

    /*//@JsonManagedReference
    @JoinColumn(name = "id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AtividadesDesenvolvidas> atividadesDesenvolvidas;*/

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Profissao profissao;

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