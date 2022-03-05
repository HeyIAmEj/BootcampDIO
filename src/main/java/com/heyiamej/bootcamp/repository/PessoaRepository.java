package com.heyiamej.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.heyiamej.bootcamp.entity.Pessoa;

import java.util.List;

@Repository
@Component
@EnableJpaRepositories
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("select p from Pessoa p where p.profissao = ?1 and p.nivel = ?2")
    List<Pessoa> findPessoasByProfissaoAndNivel(int profissao, int nivel);

}