package com.solutis.desafiolocadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.Fabricante;
import com.solutis.desafiolocadora.repository.FabricanteRepository;

@Service
public class FabricanteService {

	@Autowired
	private FabricanteRepository repository;

	public List<Fabricante> findAll() {
		return repository.findAll();
	}

	public Fabricante findById(Long id) {
		Optional<Fabricante> obj = repository.findById(id);
		return obj.get();
	}
}
