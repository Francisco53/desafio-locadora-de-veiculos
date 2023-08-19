package com.solutis.desafiolocadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.Acessorio;
import com.solutis.desafiolocadora.repositories.AcessorioRepository;
import com.solutis.desafiolocadora.services.exceptions.ResourceNotFoundException;

@Service
public class AcessorioService {

	@Autowired
	private AcessorioRepository repository;

	public List<Acessorio> findAll() {
		return repository.findAll();
	}

	public Acessorio findById(Long id) {
		Optional<Acessorio> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Acessorio insert(Acessorio obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Acessorio update(Long id, Acessorio obj) {
		Acessorio entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	public void updateData(Acessorio entity, Acessorio obj) {
		entity.setDescricao(obj.getDescricao());
	}
}
