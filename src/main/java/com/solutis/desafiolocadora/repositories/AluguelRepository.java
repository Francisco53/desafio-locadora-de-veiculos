package com.solutis.desafiolocadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutis.desafiolocadora.entities.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

}
