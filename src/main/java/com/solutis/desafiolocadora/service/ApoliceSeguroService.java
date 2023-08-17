package com.solutis.desafiolocadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.ApoliceSeguro;
import com.solutis.desafiolocadora.repository.ApoliceSeguroRepository;

@Service
public class ApoliceSeguroService {

	@Autowired
	private ApoliceSeguroRepository repository;

	public List<ApoliceSeguro> findAll() {
		return repository.findAll();
	}

	public ApoliceSeguro findById(Long id) {
		Optional<ApoliceSeguro> obj = repository.findById(id);
		return obj.get();
	}
}
