package com.heyiamej.bootcamp.controller;

import com.heyiamej.bootcamp.dto.request.PagamentoDTO;
import com.heyiamej.bootcamp.dto.request.PessoaDTO;
import com.heyiamej.bootcamp.dto.response.MessageResponseDTO;
import com.heyiamej.bootcamp.exception.PessoaNaoEncontradaException;
import com.heyiamej.bootcamp.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pagamento")
public class PagamentoController {
    private PagamentoService pagamentoService;

    @Autowired(required = true)
    public PagamentoController(PagamentoService pagamentoService) {
        super();
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponseDTO criarPagamento(@PathVariable Long id, @RequestBody PagamentoDTO pagamentoDTO)  throws PessoaNaoEncontradaException {
        return pagamentoService.addPagamento(id, pagamentoDTO);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<PagamentoDTO> listarTodosPagamentos() {
        return pagamentoService.listAllPagamentos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<PagamentoDTO> listarPagamentoPorIdPessoa(@PathVariable Long id)  throws PessoaNaoEncontradaException {
        return pagamentoService.listAllPagamentosPessoa(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletarPagamento(@PathVariable Long id)  throws PessoaNaoEncontradaException {
        pagamentoService.deletePagamento(id);
    }

}
