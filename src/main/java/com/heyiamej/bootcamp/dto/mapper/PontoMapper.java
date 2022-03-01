package com.heyiamej.bootcamp.dto.mapper;

import com.heyiamej.bootcamp.dto.request.PessoaDTO;
import com.heyiamej.bootcamp.dto.request.PontoDTO;
import com.heyiamej.bootcamp.entity.Pessoa;
import com.heyiamej.bootcamp.entity.Ponto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface PontoMapper {
    public static final PontoMapper INSTANCE = Mappers.getMapper(PontoMapper.class);

    Ponto toPonto(PontoDTO pontoDTO);


    PontoDTO toPontoDTO(Ponto ponto);

}
