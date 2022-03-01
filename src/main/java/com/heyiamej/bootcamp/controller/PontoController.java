package com.heyiamej.bootcamp.controller;

import com.heyiamej.bootcamp.dto.mapper.PontoMapper;
import com.heyiamej.bootcamp.dto.request.PessoaDTO;
import com.heyiamej.bootcamp.dto.request.PontoDTO;
import com.heyiamej.bootcamp.entity.Pessoa;
import com.heyiamej.bootcamp.entity.Ponto;
import com.heyiamej.bootcamp.exception.PessoaNaoEncontradaException;
import com.heyiamej.bootcamp.repository.PessoaRepository;
import com.heyiamej.bootcamp.repository.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/ponto")
public class PontoController {

    private PontoMapper pontoMapper = PontoMapper.INSTANCE;
    private PontoRepository pontoRepository;

    @Autowired
    public PontoController(PontoRepository pontoRepository) {
        this.pontoRepository = pontoRepository;
    }

    @GetMapping("/{id}")
    public List<PontoDTO> findById(@PathVariable Long id) throws PessoaNaoEncontradaException {
        List<Ponto> pontoList = new ArrayList<>();
        try {
            pontoList = pontoRepository.findByPessoaId(id);
        }catch (Exception e){
            throw new PessoaNaoEncontradaException(id);
        }
        return pontoList
                .stream()
                .map(pontoMapper::toPontoDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}")
    public String createById(@PathVariable Long id, @RequestBody PontoDTO pontoDTO) throws PessoaNaoEncontradaException {
        Ponto ponto = pontoMapper.toPonto(pontoDTO);
        try {
            ponto.setPessoa_id(id);
            Ponto pontoSalvo = pontoRepository.save(ponto);
            return String.format("Ponto %d, salvo para a Pessoa %d", pontoSalvo.getId(), pontoSalvo.getPessoa_id());
        }catch (Exception e){
            throw new PessoaNaoEncontradaException(id);
        }
    }


}
