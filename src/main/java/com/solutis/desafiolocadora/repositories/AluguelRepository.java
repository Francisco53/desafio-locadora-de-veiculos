package com.solutis.desafiolocadora.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutis.desafiolocadora.entities.Aluguel;
import com.solutis.desafiolocadora.entities.Carro;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

	Aluguel findByCarroAndDataEntregaLessThanEqualAndDataDevolucaoGreaterThanEqual(Carro carro, LocalDate endDate, LocalDate startDate);
}
