package com.solutis.desafiolocadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.desafiolocadora.entities.ApoliceSeguro;
import com.solutis.desafiolocadora.service.ApoliceSeguroService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/apolices")
public class ApoliceSeguroController {

	@Autowired
	private ApoliceSeguroService service;

	@GetMapping
	@Operation(summary = "Buscar e listar informações de todas as apólices de seguro")
	public ResponseEntity<List<ApoliceSeguro>> findAll() {
		List<ApoliceSeguro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Listar informações de uma apólice de seguro através de seu ID")
	public ResponseEntity<ApoliceSeguro> findById(@PathVariable Long id) {
		ApoliceSeguro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
