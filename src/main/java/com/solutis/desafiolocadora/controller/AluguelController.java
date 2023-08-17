package com.solutis.desafiolocadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.desafiolocadora.entities.Aluguel;
import com.solutis.desafiolocadora.service.AluguelService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/alugueis")
public class AluguelController {

	@Autowired
	private AluguelService service;

	@GetMapping
	@Operation(summary = "Buscar e listar informações de todos os aluguéis")
	public ResponseEntity<List<Aluguel>> findAll() {
		List<Aluguel> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Listar informações de um aluguel através de seu ID")
	public ResponseEntity<Aluguel> findById(@PathVariable Long id) {
		Aluguel obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
