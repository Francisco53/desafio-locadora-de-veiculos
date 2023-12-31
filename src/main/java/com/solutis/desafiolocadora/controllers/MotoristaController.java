package com.solutis.desafiolocadora.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.solutis.desafiolocadora.entities.Motorista;
import com.solutis.desafiolocadora.services.MotoristaService;

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

	@PostMapping
	@Operation(summary = "Inserir dados de um motorista")
	public ResponseEntity<Motorista> insert(@RequestBody Motorista obj) {
		if (service.isEmailAlreadyTaken(obj.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remover um motorista através de seu ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@Operation(summary = "Atualizar um motorista através de seu ID")
	public ResponseEntity<Motorista> update(@PathVariable Long id, @RequestBody Motorista obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
