package com.heyiamej.bootcamp.repository;

import com.heyiamej.bootcamp.entity.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
@EnableJpaRepositories
public interface PontoRepository extends JpaRepository<Ponto, Long> {
    @Query("select p from Ponto p where p.pessoa_id = ?1")
    List<Ponto> findByPessoaId(Long pessoa_id);


}