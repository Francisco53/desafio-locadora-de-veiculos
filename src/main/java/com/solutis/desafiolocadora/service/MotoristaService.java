package com.solutis.desafiolocadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.Motorista;
import com.solutis.desafiolocadora.repository.MotoristaRepository;

@Service
public class MotoristaService {

	@Autowired
	private MotoristaRepository repository;

	public List<Motorista> findAll() {
		return repository.findAll();
	}

	public Motorista findById(Long id) {
		Optional<Motorista> obj = repository.findById(id);
		return obj.get();
	}
}
