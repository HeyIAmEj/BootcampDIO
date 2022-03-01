package com.heyiamej.bootcamp.dto.request;

import com.heyiamej.bootcamp.entity.Pessoa;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PontoDTO {

    private Long id;

    @NotEmpty
    private String dataEntrada;

    private String dataSaida;

    private Integer isAtrasado;

    private Integer isExtra;

    private Integer isJustificado;

    private Long pessoa_id;

}
