package com.heyiamej.bootcamp.controller;


import com.heyiamej.bootcamp.dto.request.AtividadeDTO;
import com.heyiamej.bootcamp.dto.request.PessoaDTO;
import com.heyiamej.bootcamp.dto.request.ProfissaoDTO;
import com.heyiamej.bootcamp.dto.response.MessageResponseDTO;
import com.heyiamej.bootcamp.entity.*;
import com.heyiamej.bootcamp.exception.PessoaNaoEncontradaException;
import com.heyiamej.bootcamp.exception.ProfissaoNaoEncontradaException;
import com.heyiamej.bootcamp.repository.AtividadeRepository;
import com.heyiamej.bootcamp.repository.ProfissaoRepository;
import com.heyiamej.bootcamp.service.AtividadeService;
import com.heyiamej.bootcamp.service.PessoaService;
import com.heyiamej.bootcamp.service.ProfissaoService;
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


    @Autowired
    private ProfissaoRepository profissaoRepository;
    @Autowired
    private AtividadeRepository atividadeRepository;
    @Autowired
    private ProfissaoService profissaoService;
    @Autowired
    private AtividadeService atividadeService;

    //@ApiOperation(value = "Cria Pessoa")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponseDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.createPessoa(pessoaDTO);
    }

    //@ApiOperation(value = "Lista todas Pessoas")
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<PessoaDTO> listarTodasPessoas(){
        return pessoaService.listAll();
    }

    //@ApiOperation(value = "Lista Pessoa por Id")
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PessoaDTO listarPorId(@PathVariable Long id)  throws PessoaNaoEncontradaException {
        return pessoaService.findById(id);
    }

    //@ApiOperation(value = "Cria Todos os Testes")
    @GetMapping("/testes")
    @ResponseStatus(value = HttpStatus.OK)
    public String criarTodosTestes() throws PessoaNaoEncontradaException, ProfissaoNaoEncontradaException {
        //Criando Profissões
        MessageResponseDTO teste = profissaoService.createProfissao(new ProfissaoDTO(1L, "Ciência da Computação", "CCO", null));
        teste = profissaoService.createProfissao(new ProfissaoDTO(2L, "Recursos Humanos", "RH", null));
        teste = profissaoService.createProfissao(new ProfissaoDTO(3L, "Técnico em Manutenção", "TM", null));

        //Criando Atividades
        teste = atividadeService.createAtividade(new AtividadeDTO(1L, "Desenvolver API Basica", "Conceitos básicos de API", 3, 1));
        teste = atividadeService.createAtividade(new AtividadeDTO(2L, "Mentoria Junior", "Mentoria aos Juniores", 2, 1));
        teste = atividadeService.createAtividade(new AtividadeDTO(3L, "Reuniões de Planejamento", "Reuniões de planejamento e contratos com Cliente", 1, 1));
        teste = atividadeService.createAtividade(new AtividadeDTO(4L, "Efetivação de Pessoas", "Efetivação de contratos de pessoas", 1, 2));
        teste = atividadeService.createAtividade(new AtividadeDTO(5L, "Processos Seletivos", "Planejamento de processos seletivos", 3, 2));
        teste = atividadeService.createAtividade(new AtividadeDTO(6L, "Arquitetura de Softwares", "Desenvolvimento de arquiteturas para softwares", 1, 1));

        Profissao profissao1 = profissaoService.getProfissaoById(1L);
        Profissao profissao2 = profissaoService.getProfissaoById(2L);
        Profissao profissao3 = profissaoService.getProfissaoById(3L);

        //Criando Pessoas
        teste = pessoaService.createPessoa(new PessoaDTO(1L, "Everton", "Jose", "748.682.614-36", "03/07/1999", profissao1, 1, null, null, null));
        teste = pessoaService.createPessoa(new PessoaDTO(2L, "Maria", "Soares", "256.346.596-63", "03/07/1999", profissao1, 1, null, null, null));
        teste = pessoaService.createPessoa(new PessoaDTO(3L, "Mariana", "Santos", "088.117.483-13", "03/07/1999", profissao1, 2, null, null, null));
        teste = pessoaService.createPessoa(new PessoaDTO(4L, "Jose", "Silva", "603.836.852-30", "03/07/1999", profissao1, 3, null, null, null));
        teste = pessoaService.createPessoa(new PessoaDTO(5L, "Bruna", "Lopes", "682.058.527-66", "03/07/1999", profissao2, 1, null, null, null));
        teste = pessoaService.createPessoa(new PessoaDTO(6L, "Armando", "Silva", "424.397.284-20", "03/07/1999", profissao2, 2, null, null, null));
        teste = pessoaService.createPessoa(new PessoaDTO(7L, "Clóvis", "Santos", "754.767.541-72", "03/07/1999", profissao3, 3, null, null, null));
        teste = pessoaService.createPessoa(new PessoaDTO(8L, "Marta", "Pereira", "948.778.826-34", "03/07/1999", profissao3, 2, null, null, null));
        return "Criado com sucesso!";
    }

    //@ApiOperation(value = "Atualiza Pessoa por Id")
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public MessageResponseDTO atualizarPorId(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO)  throws PessoaNaoEncontradaException {
        return pessoaService.atualizarPessoaById(id, pessoaDTO);
    }

    //@ApiOperation(value = "Deleta Pessoa por Id")
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