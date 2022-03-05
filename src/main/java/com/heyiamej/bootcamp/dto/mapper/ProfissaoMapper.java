package com.heyiamej.bootcamp.dto.mapper;

import com.heyiamej.bootcamp.dto.request.ProfissaoDTO;
import com.heyiamej.bootcamp.entity.Profissao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProfissaoMapper {

    public static final ProfissaoMapper INSTANCE = Mappers.getMapper(ProfissaoMapper.class);

    //@Mapping(source="dataNascimento", target="dataNascimento", dateFormat="dd-MM-yyyy")
    public abstract Profissao toProfissao(ProfissaoDTO profissaoDTO);

    public abstract ProfissaoDTO toDTO(Profissao profissao);

}