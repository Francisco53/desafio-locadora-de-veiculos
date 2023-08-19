package com.solutis.desafiolocadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutis.desafiolocadora.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
