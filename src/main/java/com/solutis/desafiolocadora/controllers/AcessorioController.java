package com.solutis.desafiolocadora.controllers;

import java.net.URI;
import java.util.List;

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
import com.solutis.desafiolocadora.services.AcessorioService;

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

	@PostMapping
	@Operation(summary = "Inserir dados de um acessório")
	public ResponseEntity<Acessorio> insert(@RequestBody Acessorio obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remover um acessório através de seu ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@Operation(summary = "Atualizar um acessório através de seu ID")
	public ResponseEntity<Acessorio> update(@PathVariable Long id, @RequestBody Acessorio obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
