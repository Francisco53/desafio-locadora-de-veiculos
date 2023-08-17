package com.solutis.desafiolocadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.desafiolocadora.entities.ModeloCarro;
import com.solutis.desafiolocadora.service.ModeloCarroService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/modelos")
public class ModeloCarroController {

	@Autowired
	private ModeloCarroService service;

	@GetMapping
	@Operation(summary = "Buscar e listar informações de todos os modelos de carros")
	public ResponseEntity<List<ModeloCarro>> findAll() {
		List<ModeloCarro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Listar informações de um modelo de carro através de seu ID")
	public ResponseEntity<ModeloCarro> findById(@PathVariable Long id) {
		ModeloCarro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
