package com.solutis.desafiolocadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.desafiolocadora.entities.Motorista;
import com.solutis.desafiolocadora.service.MotoristaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/motoristas")
public class MotoristaController {

	@Autowired
	private MotoristaService service;

	@GetMapping
	@Operation(summary = "Buscar e listar informações de todos os motoristas")
	public ResponseEntity<List<Motorista>> findAll() {
		List<Motorista> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Listar informações de um motorista através de seu ID")
	public ResponseEntity<Motorista> findById(@PathVariable Long id) {
		Motorista obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
