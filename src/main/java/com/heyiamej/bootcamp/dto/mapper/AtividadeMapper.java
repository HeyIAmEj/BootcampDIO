package com.heyiamej.bootcamp.dto.mapper;

import com.heyiamej.bootcamp.dto.request.AtividadeDTO;
import com.heyiamej.bootcamp.entity.Atividade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AtividadeMapper {

    public static final AtividadeMapper INSTANCE = Mappers.getMapper(AtividadeMapper.class);

    //@Mapping(source="dataNascimento", target="dataNascimento", dateFormat="dd-MM-yyyy")
    public abstract Atividade toAtividade(AtividadeDTO atividadeDTO);

    public abstract AtividadeDTO toDTO(Atividade atividade);

}