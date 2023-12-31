package com.solutis.desafiolocadora.configs;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.solutis.desafiolocadora.entities.Acessorio;
import com.solutis.desafiolocadora.entities.Aluguel;
import com.solutis.desafiolocadora.entities.ApoliceSeguro;
import com.solutis.desafiolocadora.entities.Carro;
import com.solutis.desafiolocadora.entities.Fabricante;
import com.solutis.desafiolocadora.entities.Funcionario;
import com.solutis.desafiolocadora.entities.ModeloCarro;
import com.solutis.desafiolocadora.entities.Motorista;
import com.solutis.desafiolocadora.entities.enumerations.Categoria;
import com.solutis.desafiolocadora.entities.enumerations.Sexo;
import com.solutis.desafiolocadora.repositories.AcessorioRepository;
import com.solutis.desafiolocadora.repositories.AluguelRepository;
import com.solutis.desafiolocadora.repositories.ApoliceSeguroRepository;
import com.solutis.desafiolocadora.repositories.CarroRepository;
import com.solutis.desafiolocadora.repositories.FabricanteRepository;
import com.solutis.desafiolocadora.repositories.FuncionarioRepository;
import com.solutis.desafiolocadora.repositories.ModeloCarroRepository;
import com.solutis.desafiolocadora.repositories.MotoristaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private MotoristaRepository motoristaRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	@Autowired
	private ModeloCarroRepository modeloCarroRepository;
	
	@Autowired
	private AcessorioRepository acessorioRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private ApoliceSeguroRepository apoliceSeguroRepository;
	
	@Autowired
	private AluguelRepository aluguelRepository;

	@Override
	public void run(String... args) throws Exception {

		Motorista motorista1 = new Motorista(null, "João Silva", LocalDate.of(1990, 5, 15), "89151920018", "joao@example.com", Sexo.MASCULINO, "95875361787");
		Motorista motorista2 = new Motorista(null, "Maria Souza", LocalDate.of(1988, 9, 20), "15198499072", "maria@example.com", Sexo.FEMININO, "45945766602");

		motoristaRepository.saveAll(Arrays.asList(motorista1, motorista2));

		Funcionario funcionario1 = new Funcionario(null, "Carlos Oliveira", LocalDate.of(1985, 3, 10), "371.605.780-07", "carlos@example.com", Sexo.MASCULINO, "1234");
		Funcionario funcionario2 = new Funcionario(null, "Ana Santos", LocalDate.of(1995, 11, 8), "901.438.960-40", "ana@example.com", Sexo.FEMININO, "123456");

		funcionarioRepository.saveAll(Arrays.asList(funcionario1, funcionario2));

		Fabricante fabricante1 = new Fabricante(null, "Toyota");
		Fabricante fabricante2 = new Fabricante(null, "Honda");

		fabricanteRepository.saveAll(Arrays.asList(fabricante1, fabricante2));
		
		ModeloCarro modelo1 = new ModeloCarro(null, "Sedan", Categoria.SEDAN_COMPACTO, fabricante1);
		ModeloCarro modelo2 = new ModeloCarro(null, "Minivan", Categoria.MINIVAN, fabricante2);
		
		modeloCarroRepository.saveAll(Arrays.asList(modelo1, modelo2));
		
		Acessorio acessorio1 = new Acessorio(null, "Airbag");
		Acessorio acessorio2 = new Acessorio(null, "Central multimídia");

		acessorioRepository.saveAll(Arrays.asList(acessorio1, acessorio2));
		
		Carro carro1 = new Carro(null, "ABC1234", "12345678901234567", "Azul", "https://example.com/car1.jpg", new BigDecimal("150.00"), modelo1);
		Carro carro2 = new Carro(null, "XYZ5678", "98765432109876543", "Vermelho", "https://example.com/car2.jpg", new BigDecimal("200.00"), modelo2);

		carro1.addAcessorio(acessorio1);

		carroRepository.saveAll(Arrays.asList(carro1, carro2));
		
		ApoliceSeguro apolice1 = new ApoliceSeguro(null, new BigDecimal("1000.00"), true, true, true);
		ApoliceSeguro apolice2 = new ApoliceSeguro(null, new BigDecimal("1500.00"), false, true, false);
		
		apoliceSeguroRepository.saveAll(Arrays.asList(apolice1, apolice2));
		
//		Aluguel aluguel1 = new Aluguel(null, Calendar.getInstance(), LocalDate.of(2023, 9, 10), LocalDate.of(2023, 9, 15), apolice1, motorista1, carro1);
//		Aluguel aluguel2 = new Aluguel(null, Calendar.getInstance(), LocalDate.of(2023, 8, 23), LocalDate.of(2023, 8, 23), apolice2, motorista2, carro2);
//		
//		aluguelRepository.saveAll(Arrays.asList(aluguel1, aluguel2));
	}
}
