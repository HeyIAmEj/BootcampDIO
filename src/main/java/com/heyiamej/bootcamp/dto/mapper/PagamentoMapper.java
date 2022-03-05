package com.heyiamej.bootcamp.dto.mapper;

import com.heyiamej.bootcamp.dto.request.PagamentoDTO;
import com.heyiamej.bootcamp.entity.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {
    public static final PagamentoMapper INSTANCE = Mappers.getMapper(PagamentoMapper.class);

    @Mapping(source="data", target="data", dateFormat="dd/MM/yyyy")
    Pagamento toPagamento(PagamentoDTO pagamentoDTO);


    PagamentoDTO toPagamentoDTO(Pagamento pagamento);

}
