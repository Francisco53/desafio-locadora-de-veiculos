package com.solutis.desafiolocadora.controllers;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.solutis.desafiolocadora.entities.Acessorio;
import com.solutis.desafiolocadora.entities.Carro;
import com.solutis.desafiolocadora.entities.enumerations.Categoria;
import com.solutis.desafiolocadora.repositories.AcessorioRepository;
import com.solutis.desafiolocadora.services.CarroService;

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
	@Operation(summary = "Buscar carro através de seu acessório")
	public List<Carro> listarVeiculosPorAcessorios(@PathVariable String descricao) {
		Acessorio acessorio = acessorioRepository.findByDescricao(descricao);
		if (acessorio != null) {
			List<Carro> carros = service.findAll();
			return carros.stream()
					.filter(carro -> carro.getAcessorios().contains(acessorio))
					.collect(Collectors.toList());
		} else {
			return Collections.emptyList();
		}
	}

	@GetMapping("/buscar/categoria/{categoria}")
	@Operation(summary = "Buscar carro através da categoria")
	public ResponseEntity<List<Carro>> listarVeiculosPorCategoria(@PathVariable Categoria categoria) {
		List<Carro> carros = service.findAll();

		List<Carro> carrosPorCategoria = carros.stream()
				.filter(carro -> carro.getModelo().getCategoria().equals(categoria))
				.collect(Collectors.toList());

		if (!carrosPorCategoria.isEmpty()) {
			return ResponseEntity.ok(carrosPorCategoria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@Operation(summary = "Inserir dados de um carro")
	public ResponseEntity<Carro> insert(@RequestBody Carro obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remover um carro através de seu ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@Operation(summary = "Atualizar um carro através de seu ID")
	public ResponseEntity<Carro> update(@PathVariable Long id, @RequestBody Carro obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
