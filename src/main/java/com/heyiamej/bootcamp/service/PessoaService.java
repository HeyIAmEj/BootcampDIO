package com.heyiamej.bootcamp.service;

import com.heyiamej.bootcamp.dto.mapper.PontoMapper;
import com.heyiamej.bootcamp.dto.request.PontoDTO;
import com.heyiamej.bootcamp.entity.Pessoa;
import com.heyiamej.bootcamp.entity.Ponto;
import com.heyiamej.bootcamp.exception.PessoaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyiamej.bootcamp.dto.mapper.PessoaMapper;
import com.heyiamej.bootcamp.dto.request.PessoaDTO;
import com.heyiamej.bootcamp.dto.response.MessageResponseDTO;
import com.heyiamej.bootcamp.repository.PessoaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    private PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;
    private PontoMapper pontoMapper = PontoMapper.INSTANCE;



    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO createPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaMapper.toPessoa(pessoaDTO);

        //pessoa.setAtividadesDesenvolvidas(null);
        //pessoa.setAtividadesDesenvolvidas(atividadesDesenvolvidasRepository.findAtividadesByProfissaoAndNivel(pessoa.getProfissao(), pessoa.getNivel()));

        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        return criarMensagemResposta("Pessoa criada com Id: ", pessoaSalva);

    }

    public List<PessoaDTO> listAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoas
                .stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO findById(Long id) throws PessoaNaoEncontradaException {
        Pessoa pessoa = verifyIfExists(id);
        return pessoaMapper.toDTO(pessoa);
    }

    private Pessoa verifyIfExists(Long id) throws PessoaNaoEncontradaException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));
    }

    public void deletePessoaById(Long id) throws PessoaNaoEncontradaException {
        verifyIfExists(id);
        pessoaRepository.deleteById(id);
    }


    public MessageResponseDTO atualizarPessoaById(Long id, PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
        verifyIfExists(id);
        Pessoa pessoa = pessoaMapper.toPessoa(pessoaDTO);
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return criarMensagemResposta("Pessoa Atualizada com Id: ", pessoaSalva);
    }

    private MessageResponseDTO criarMensagemResposta(String x, Pessoa pessoaSalva) {
        return MessageResponseDTO.builder().message(x + pessoaSalva.getId()).build();
    }

    public MessageResponseDTO createPessoaPonto(Long id, PontoDTO pontoDTO) throws PessoaNaoEncontradaException {
        Ponto ponto = pontoMapper.toPonto(pontoDTO);
        Pessoa pessoa = verifyIfExists(id);
        ponto.setPessoa_id(id);
        pessoa.getPontos().add(ponto);
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return criarMensagemResposta("Ponto adicionado para: ", pessoaSalva);

    }
}