package com.heyiamej.bootcamp.controller;


import com.heyiamej.bootcamp.dto.request.PessoaDTO;
import com.heyiamej.bootcamp.dto.request.PontoDTO;
import com.heyiamej.bootcamp.dto.response.MessageResponseDTO;
import com.heyiamej.bootcamp.entity.Blog;
import com.heyiamej.bootcamp.entity.Pessoa;
import com.heyiamej.bootcamp.entity.Ponto;
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

    @GetMapping("/criarPessoasTeste")
    @ResponseStatus(value = HttpStatus.OK)
    public String criarPessoasTeste()  throws PessoaNaoEncontradaException {
        PessoaDTO pessoa1 = new PessoaDTO(1L, "Everton", "Jose", "133.118.144-77", "03/07/1999", null, null);
        PessoaDTO pessoa2 = new PessoaDTO(2L, "Teste1", "Soares", "143.148.184-47", "03/07/1999", null, null);
        PessoaDTO pessoa3 = new PessoaDTO(3L, "Teste2", "Santos", "143.128.184-47", "03/07/1999", null, null);
        PessoaDTO pessoa4 = new PessoaDTO(4L, "Teste3", "Silva", "113.148.114-47", "03/07/1999", null, null);
        pessoaService.createPessoa(pessoa1);
        pessoaService.createPessoa(pessoa2);
        pessoaService.createPessoa(pessoa3);
        pessoaService.createPessoa(pessoa3);
        return "Criado com sucesso!";
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

    /*

    CRIAR PONTO ATUALIZANDO LISTA DE PONTO DE PESSOA
    [NÃO RECOMENDADO] POIS <PESSOA> NÃO PODE TER ACESSO A ESSA FUNCAO, EVITANDO FRAUDE
    CRIAR PONTO FAZENDO POST EM /api/v1/ponto/{id} 

    @PostMapping("/{id}/ponto")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponseDTO criarPessoa(@PathVariable Long id, @RequestBody @Valid PontoDTO pontoDTO) throws PessoaNaoEncontradaException {
        return pessoaService.createPessoaPonto(id, pontoDTO);
    }
    */

}