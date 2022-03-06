package com.heyiamej.bootcamp.controller;

import com.heyiamej.bootcamp.dto.mapper.PontoMapper;
import com.heyiamej.bootcamp.dto.request.PessoaDTO;
import com.heyiamej.bootcamp.dto.request.PontoDTO;
import com.heyiamej.bootcamp.entity.Pessoa;
import com.heyiamej.bootcamp.entity.Ponto;
import com.heyiamej.bootcamp.exception.PessoaNaoEncontradaException;
import com.heyiamej.bootcamp.repository.PessoaRepository;
import com.heyiamej.bootcamp.repository.PontoRepository;
import com.heyiamej.bootcamp.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private PessoaService pessoaService;

    @Autowired
    public PontoController(PontoRepository pontoRepository) {
        this.pontoRepository = pontoRepository;
    }

    @Operation(summary = "Lista Ponto por Id de Pessoa")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    public List<PontoDTO> findById(@PathVariable Long id) throws PessoaNaoEncontradaException {
        List<Ponto> pontoList;
        pessoaService.findById(id);
        pontoList = pontoRepository.findByPessoaId(id);
        return pontoList
                .stream()
                .map(pontoMapper::toPontoDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Cria Ponto para Pessoa por Id")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/{id}")
    public String createById(@PathVariable Long id, @RequestBody PontoDTO pontoDTO) throws PessoaNaoEncontradaException {
        Ponto ponto = pontoMapper.toPonto(pontoDTO);
        pessoaService.findById(id);
        ponto.setPessoa_id(id);
        Ponto pontoSalvo = pontoRepository.save(ponto);
        return String.format("Ponto %d, salvo para a Pessoa %d", pontoSalvo.getId(), pontoSalvo.getPessoa_id());
    }


}
