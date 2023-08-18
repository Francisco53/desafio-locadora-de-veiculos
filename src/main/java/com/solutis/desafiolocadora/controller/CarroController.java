package com.solutis.desafiolocadora.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.solutis.desafiolocadora.entities.Acessorio;
import com.solutis.desafiolocadora.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.desafiolocadora.entities.Carro;
import com.solutis.desafiolocadora.service.CarroService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/carros")
public class CarroController {

	@Autowired
	private CarroService service;

	@Autowired
	private AcessorioRepository acessorioRepository;

	@GetMapping
	@Operation(summary = "Buscar e listar informações de todos os carros")
	public ResponseEntity<List<Carro>> findAll() {
		List<Carro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Listar informações de um carro através de seu ID")
	public ResponseEntity<Carro> findById(@PathVariable Long id) {
		Carro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/buscar/acessorios/{descricao}")
	public List<Carro> listarVeiculosPorAcessorios(@PathVariable String descricao) {
		Acessorio acessorio = acessorioRepository.findByDescricao(descricao); // Supondo que você tenha um método findByNome no seu AcessorioRepository
		if (acessorio != null) {
			List<Carro> carros = service.findAll();
			return carros.stream()
					.filter(carro -> carro.getAcessorios().contains(acessorio))
					.collect(Collectors.toList());
		} else {
			return Collections.emptyList();
		}
	}

}
