package com.heyiamej.bootcamp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // INFORMACOES

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(nullable = true)
    private String genero;

    // CONTATO
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Telefone> telefones;

    // DOCUMENTOS

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(nullable = false, unique=true)
    private String numeroDocumento;

    // ACESSO
    @Column(nullable = false, unique=true)
    private String email;

    @Column(nullable = false)
    private String senha;



    public void setNumeroDocumento(String numeroDocumento) {
        if(numeroDocumento.length() == 11) setTipoDocumento(TipoDocumento.FISICA);
        else if(numeroDocumento.length() == 14) setTipoDocumento(TipoDocumento.JURIDICA);

    }
}