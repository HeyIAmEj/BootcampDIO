package com.heyiamej.bootcamp.repository;

import com.heyiamej.bootcamp.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
@EnableJpaRepositories
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    @Query("select p from Pagamento p where p.pessoa_id = ?1")
    List<Pagamento> findByPessoaId(Long pessoa_id);
}
