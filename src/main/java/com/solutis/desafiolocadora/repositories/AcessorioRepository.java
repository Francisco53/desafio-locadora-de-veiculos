package com.solutis.desafiolocadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutis.desafiolocadora.entities.Acessorio;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
	
    Acessorio findByDescricao(String descricao);
}
