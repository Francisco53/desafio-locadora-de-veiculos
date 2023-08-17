package com.solutis.desafiolocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutis.desafiolocadora.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
