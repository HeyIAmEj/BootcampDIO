package com.heyiamej.bootcamp.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String nome;

    private String descricao;

    private Long inscritos;


}