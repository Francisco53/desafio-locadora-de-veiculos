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

import com.solutis.desafiolocadora.entities.ApoliceSeguro;
import com.solutis.desafiolocadora.services.ApoliceSeguroService;

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

	@PostMapping
	@Operation(summary = "Inserir dados de uma apólice de seguro")
	public ResponseEntity<ApoliceSeguro> insert(@RequestBody ApoliceSeguro obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remover uma apólice de seguro através de seu ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@Operation(summary = "Atualizar uma apólice de seguro através de seu ID")
	public ResponseEntity<ApoliceSeguro> update(@PathVariable Long id, @RequestBody ApoliceSeguro obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
