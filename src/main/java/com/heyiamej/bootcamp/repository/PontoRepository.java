package com.heyiamej.bootcamp.repository;

import com.heyiamej.bootcamp.entity.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
@EnableJpaRepositories
public interface PontoRepository extends JpaRepository<Ponto, Long> {

}