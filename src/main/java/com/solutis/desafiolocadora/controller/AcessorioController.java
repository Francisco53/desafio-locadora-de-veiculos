package com.solutis.desafiolocadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.desafiolocadora.entities.Acessorio;
import com.solutis.desafiolocadora.service.AcessorioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/acessorios")
public class AcessorioController {

	@Autowired
	private AcessorioService service;

	@GetMapping
	@Operation(summary = "Buscar e listar informações de todos os acessórios")
	public ResponseEntity<List<Acessorio>> findAll() {
		List<Acessorio> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Listar informações de um acessório através de seu ID")
	public ResponseEntity<Acessorio> findById(@PathVariable Long id) {
		Acessorio obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
