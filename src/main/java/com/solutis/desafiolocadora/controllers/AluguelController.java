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

import com.solutis.desafiolocadora.dto.ConfirmacaoAluguelDto;
import com.solutis.desafiolocadora.entities.Aluguel;
import com.solutis.desafiolocadora.services.AluguelService;
import com.solutis.desafiolocadora.services.CarrinhoDeComprasService;
import com.solutis.desafiolocadora.util.ResponseMessage;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/alugueis")
public class AluguelController {

	@Autowired
	private AluguelService service;

	@Autowired
	private CarrinhoDeComprasService carrinhoDeComprasService;

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

	@PostMapping
	@Operation(summary = "Inserir dados de um aluguel")
	public ResponseEntity<Aluguel> insert(@RequestBody Aluguel obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PostMapping("/efetivar")
	@Operation(summary = "Efetivar a confirmação dos aluguéis no carrinho")
	public ResponseEntity<ResponseMessage> efetivarAluguel(@RequestBody ConfirmacaoAluguelDto confirmacaoDto) {
		ResponseMessage responseMessage = carrinhoDeComprasService.confirmarAluguel(confirmacaoDto);
		return ResponseEntity.ok(responseMessage);
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remover um aluguel através de seu ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@Operation(summary = "Atualizar um aluguel através de seu ID")
	public ResponseEntity<Aluguel> update(@PathVariable Long id, @RequestBody Aluguel obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
