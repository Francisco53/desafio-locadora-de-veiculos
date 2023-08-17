package com.solutis.desafiolocadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.ModeloCarro;
import com.solutis.desafiolocadora.repository.ModeloCarroRepository;

@Service
public class ModeloCarroService {

	@Autowired
	private ModeloCarroRepository repository;

	public List<ModeloCarro> findAll() {
		return repository.findAll();
	}

	public ModeloCarro findById(Long id) {
		Optional<ModeloCarro> obj = repository.findById(id);
		return obj.get();
	}
}
