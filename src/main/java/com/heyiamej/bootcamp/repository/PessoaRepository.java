package com.heyiamej.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.heyiamej.bootcamp.entity.Pessoa;

@Repository
@Component
@EnableJpaRepositories
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}