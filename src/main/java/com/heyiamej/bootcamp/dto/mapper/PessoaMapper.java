package com.heyiamej.bootcamp.dto.mapper;

import com.heyiamej.bootcamp.dto.request.PessoaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.heyiamej.bootcamp.entity.Pessoa;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    public static final PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    @Mapping(source="dataNascimento", target="dataNascimento", dateFormat="dd/MM/yyyy")
    public abstract Pessoa toPessoa(PessoaDTO pessoaDTO);

    public abstract PessoaDTO toDTO(Pessoa pessoa);
}