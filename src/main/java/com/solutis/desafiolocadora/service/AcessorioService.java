package com.solutis.desafiolocadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.Acessorio;
import com.solutis.desafiolocadora.repository.AcessorioRepository;

@Service
public class AcessorioService {

	@Autowired
	private AcessorioRepository repository;

	public List<Acessorio> findAll() {
		return repository.findAll();
	}

	public Acessorio findById(Long id) {
		Optional<Acessorio> obj = repository.findById(id);
		return obj.get();
	}
}
