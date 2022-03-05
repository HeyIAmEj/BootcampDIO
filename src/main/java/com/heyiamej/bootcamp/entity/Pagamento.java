package com.heyiamej.bootcamp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String data;

    private Integer isAdiantado;

    private Integer isAtrasado;

    @Column(nullable = false)
    private Double valor;

    @JoinColumn(name = "pessoa_id")
    private Long pessoa_id;
}
