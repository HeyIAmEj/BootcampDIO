package com.heyiamej.bootcamp.service;

import com.heyiamej.bootcamp.dto.mapper.PagamentoMapper;
import com.heyiamej.bootcamp.dto.mapper.PessoaMapper;
import com.heyiamej.bootcamp.dto.request.PagamentoDTO;
import com.heyiamej.bootcamp.dto.request.PessoaDTO;
import com.heyiamej.bootcamp.dto.response.MessageResponseDTO;
import com.heyiamej.bootcamp.entity.Pagamento;
import com.heyiamej.bootcamp.entity.Pessoa;
import com.heyiamej.bootcamp.exception.PessoaNaoEncontradaException;
import com.heyiamej.bootcamp.repository.PagamentoRepository;
import com.heyiamej.bootcamp.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PessoaService pessoaService;

    private PagamentoMapper pagamentoMapper = PagamentoMapper.INSTANCE;

    @Autowired
    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    private MessageResponseDTO criarMensagemResposta(String x, PessoaDTO pessoaDTO) {
        return MessageResponseDTO.builder().message(x + pessoaDTO.getNome() + " " + pessoaDTO.getSobrenome()).build();
    }

    // Adiciona um novo pagamento para uma pessoa [POST]
    // ./api/v1/pagamento/{id}
    public MessageResponseDTO addPagamento(Long id, PagamentoDTO pagamentoDTO) throws PessoaNaoEncontradaException {
        PessoaDTO pessoaDTO = pessoaService.findById(id);
        Pagamento pagamento = pagamentoMapper.toPagamento(pagamentoDTO);
        pagamento.setPessoa_id(id);
        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);
        return criarMensagemResposta("Um pagamento foi adicionado para: ", pessoaDTO);
    }

    // Visualizar todos os pagamentos [GET]
    // ./api/v1/pagamento
    public List<PagamentoDTO> listAllPagamentos() {
        List<Pagamento> pagamentosList = pagamentoRepository.findAll();
        return pagamentosList
                .stream()
                .map(pagamentoMapper::toPagamentoDTO)
                .collect(Collectors.toList());
    }


    // Visualizar todos os pagamentos para uma Pessoa [GET]
    // ./api/v1/pagamento/1
    public List<PagamentoDTO> listAllPagamentosPessoa(Long id) throws PessoaNaoEncontradaException {
        pessoaService.findById(id);
        List<Pagamento> pagamentosList = pagamentoRepository.findByPessoaId(id);
        return pagamentosList
                .stream()
                .map(pagamentoMapper::toPagamentoDTO)
                .collect(Collectors.toList());
    }

    // Não é necessário atualizar um pagamento
    // Apagar um pagamento (em caso de erro) [DELETE]
    // ./api/v1/pagamento/1
    public String deletePagamento(Long id) {
        pagamentoRepository.deleteById(id);
        return "Pagamento de Id: " + id + " foi deletado com sucesso!";
    }


}
