package com.solutis.desafiolocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutis.desafiolocadora.entities.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

}
