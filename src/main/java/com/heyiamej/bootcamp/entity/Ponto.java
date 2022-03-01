package com.heyiamej.bootcamp.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dataEntrada;

    @Column(nullable = true)
    private String dataSaida;

    @Column(nullable = false)
    private Integer isAtrasado;

    @Column(nullable = true)
    private Integer isExtra;

    @Column(nullable = true)
    private Integer isJustificado;

    @JoinColumn(name = "pessoa_id")
    private Long pessoa_id;

}
