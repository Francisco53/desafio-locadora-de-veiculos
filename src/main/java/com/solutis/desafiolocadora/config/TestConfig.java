package com.solutis.desafiolocadora.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.solutis.desafiolocadora.entities.Funcionario;
import com.solutis.desafiolocadora.entities.Motorista;
import com.solutis.desafiolocadora.enumeration.Sexo;
import com.solutis.desafiolocadora.repository.FuncionarioRepository;
import com.solutis.desafiolocadora.repository.MotoristaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private MotoristaRepository motoristaRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public void run(String... args) throws Exception {

		Motorista m1 = new Motorista(null, "João Silva", LocalDate.of(1990, 5, 15), "89151920018", "joao@example.com", Sexo.MASCULINO, "95875361787");
		Motorista m2 = new Motorista(null, "Maria Souza", LocalDate.of(1988, 9, 20), "15198499072", "maria@example.com", Sexo.FEMININO, "45945766602");

		motoristaRepository.saveAll(Arrays.asList(m1, m2));

		Funcionario f1 = new Funcionario(null, "Carlos Oliveira", LocalDate.of(1985, 3, 10), "371.605.780-07", "carlos@example.com", Sexo.MASCULINO, "1234");
		Funcionario f2 = new Funcionario(null, "Ana Santos", LocalDate.of(1995, 11, 8), "901.438.960-40", "ana@example.com", Sexo.FEMININO, "123456");

		funcionarioRepository.saveAll(Arrays.asList(f1, f2));
	}
}
