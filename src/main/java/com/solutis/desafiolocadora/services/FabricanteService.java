package com.solutis.desafiolocadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.Fabricante;
import com.solutis.desafiolocadora.repositories.FabricanteRepository;
import com.solutis.desafiolocadora.services.exceptions.ResourceNotFoundException;

@Service
public class FabricanteService {

	@Autowired
	private FabricanteRepository repository;

	public List<Fabricante> findAll() {
		return repository.findAll();
	}

	public Fabricante findById(Long id) {
		Optional<Fabricante> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Fabricante insert(Fabricante obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Fabricante update(Long id, Fabricante obj) {
		Fabricante entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	public void updateData(Fabricante entity, Fabricante obj) {
		entity.setNome(obj.getNome());
	}
}
