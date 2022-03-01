package com.heyiamej.bootcamp.controller;


import com.heyiamej.bootcamp.dto.request.PessoaDTO;
import com.heyiamej.bootcamp.dto.request.PontoDTO;
import com.heyiamej.bootcamp.dto.response.MessageResponseDTO;
import com.heyiamej.bootcamp.exception.PessoaNaoEncontradaException;
import com.heyiamej.bootcamp.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired(required = true)
    public PessoaController(PessoaService pessoaService) {
        super();
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponseDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.createPessoa(pessoaDTO);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<PessoaDTO> listarTodasPessoas(){
        return pessoaService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PessoaDTO listarPorId(@PathVariable Long id)  throws PessoaNaoEncontradaException {
        return pessoaService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public MessageResponseDTO atualizarPorId(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO)  throws PessoaNaoEncontradaException {
        return pessoaService.atualizarPessoaById(id, pessoaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletarPessoa(@PathVariable Long id)  throws PessoaNaoEncontradaException {
        pessoaService.deletePessoaById(id);
    }

    @PostMapping("/{id}/ponto")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponseDTO criarPessoa(@PathVariable Long id, @RequestBody @Valid PontoDTO pontoDTO) throws PessoaNaoEncontradaException {
        return pessoaService.createPessoaPonto(id, pontoDTO);
    }

}