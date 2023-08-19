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

import com.solutis.desafiolocadora.entities.Fabricante;
import com.solutis.desafiolocadora.services.FabricanteService;

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

	@PostMapping
	@Operation(summary = "Inserir dados de um fabricante")
	public ResponseEntity<Fabricante> insert(@RequestBody Fabricante obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remover um fabricante através de seu ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@Operation(summary = "Atualizar um fabricante através de seu ID")
	public ResponseEntity<Fabricante> update(@PathVariable Long id, @RequestBody Fabricante obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
