package com.solutis.desafiolocadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.desafiolocadora.entities.Fabricante;
import com.solutis.desafiolocadora.service.FabricanteService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/fabricantes")
public class FabricanteController {

	@Autowired
	private FabricanteService service;

	@GetMapping
	@Operation(summary = "Buscar e listar informações de todos os fabricantes")
	public ResponseEntity<List<Fabricante>> findAll() {
		List<Fabricante> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Listar informações de um fabricante através de seu ID")
	public ResponseEntity<Fabricante> findById(@PathVariable Long id) {
		Fabricante obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
