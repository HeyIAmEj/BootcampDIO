package com.heyiamej.bootcamp.service;

import com.heyiamej.bootcamp.dto.response.MessageResponseDTO;
import com.heyiamej.bootcamp.entity.Pessoa;
import com.heyiamej.bootcamp.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO criarPessoa(@RequestBody Pessoa pessoa){
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return MessageResponseDTO
                .builder()
                .message(String.format("Pessoa criada com Id= %d", pessoaSalva.getId()))
                .build();
    }
}
