package com.heyiamej.bootcamp.service;

import com.heyiamej.bootcamp.dto.mapper.PontoMapper;
import com.heyiamej.bootcamp.dto.mapper.ProfissaoMapper;
import com.heyiamej.bootcamp.dto.request.ProfissaoDTO;
import com.heyiamej.bootcamp.dto.response.MessageResponseDTO;
import com.heyiamej.bootcamp.entity.Profissao;
import com.heyiamej.bootcamp.exception.PessoaNaoEncontradaException;
import com.heyiamej.bootcamp.exception.ProfissaoNaoEncontradaException;
import com.heyiamej.bootcamp.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissaoService {
    private ProfissaoRepository profissaoRepository;
    private ProfissaoMapper profissaoMapper = ProfissaoMapper.INSTANCE;
    @Autowired
    public ProfissaoService(ProfissaoRepository profissaoRepository) {
        this.profissaoRepository = profissaoRepository;
    }


    public MessageResponseDTO criarResposta(Profissao profissao){
        return MessageResponseDTO.builder().message("Profissão: "+profissao.getNome()+" salva com id: "+profissao.getId()).build();
    }

    // Criar Profissao
    public MessageResponseDTO createProfissao(ProfissaoDTO profissaoDTO){
        Profissao profissao = profissaoMapper.toProfissao(profissaoDTO);
        Profissao profissaoSalva = profissaoRepository.save(profissao);
        return criarResposta(profissaoSalva);
    }

    // Ver Profissao
    public Profissao getProfissaoById(Long id) throws ProfissaoNaoEncontradaException {
        Profissao profissaoSalva = verifyIfExists(id);
        return profissaoSalva;
    }

    // Ver Profissoes
    public List<Profissao> getAllProfissao(){
        List<Profissao> profissaoList = profissaoRepository.findAll();
        return profissaoList;
    }

    public Profissao verifyIfExists(Long id) throws ProfissaoNaoEncontradaException {
        return profissaoRepository.findById(id)
                .orElseThrow(() -> new ProfissaoNaoEncontradaException(id));
    }

    // Atualizar Profissao
    public MessageResponseDTO updateProfissaoById(Long id, ProfissaoDTO profissaoDTO) throws ProfissaoNaoEncontradaException {
        verifyIfExists(id);
        Profissao profissao = profissaoMapper.toProfissao(profissaoDTO);
        Profissao profissaoSalva = profissaoRepository.save(profissao);
        return criarResposta(profissaoSalva);
    }


    // Deletar Profissao
    public void deleteProfissaoById(Long id) throws ProfissaoNaoEncontradaException {
        verifyIfExists(id);
        profissaoRepository.deleteById(id);
    }
}
