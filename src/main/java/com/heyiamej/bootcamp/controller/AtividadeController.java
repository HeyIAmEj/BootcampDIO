package com.heyiamej.bootcamp.controller;

import com.heyiamej.bootcamp.dto.request.AtividadeDTO;
import com.heyiamej.bootcamp.dto.response.MessageResponseDTO;
import com.heyiamej.bootcamp.entity.Atividade;
import com.heyiamej.bootcamp.exception.AtividadeNaoEncontradaException;
import com.heyiamej.bootcamp.service.AtividadeService;
import com.heyiamej.bootcamp.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atividade")
public class AtividadeController {

    private AtividadeService atividadeService;

    @Autowired
    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    // Cria nova Atividade
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponseDTO criaAtividade(@RequestBody AtividadeDTO atividadeDTO){
        return atividadeService.createAtividade(atividadeDTO);
    }

    // Ver Profissoes
    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public List<Atividade> verAtividadePorId() throws AtividadeNaoEncontradaException {
        return atividadeService.getAllAtividade();
    }
    // Ver Atividade por Id
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Atividade verAtividadePorId(@PathVariable Long id) throws AtividadeNaoEncontradaException {
        return atividadeService.getAtividadeById(id);
    }

    // Atualiza uma Atividade por Id
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponseDTO atualizaAtividadePorId(@PathVariable Long id, @RequestBody AtividadeDTO atividadeDTO) throws AtividadeNaoEncontradaException {
        return atividadeService.updateAtividadeById(id, atividadeDTO);
    }

    // Deleta uma Atividade por Id
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String deletaAtividadePorId(@PathVariable Long id) throws AtividadeNaoEncontradaException {
        return "Deletado";
    }
}
