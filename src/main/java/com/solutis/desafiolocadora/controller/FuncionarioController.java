package com.solutis.desafiolocadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.desafiolocadora.entities.Funcionario;
import com.solutis.desafiolocadora.service.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	@GetMapping
	@Operation(summary = "Buscar e listar informações de todos os funcionários")
	public ResponseEntity<List<Funcionario>> findAll() {
		List<Funcionario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Listar informações de um funcionario através de seu ID")
	public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
		Funcionario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
