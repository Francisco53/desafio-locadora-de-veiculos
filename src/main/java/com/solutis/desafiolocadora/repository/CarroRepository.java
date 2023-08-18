package com.solutis.desafiolocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutis.desafiolocadora.entities.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
