package com.solutis.desafiolocadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.Aluguel;
import com.solutis.desafiolocadora.repository.AluguelRepository;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepository repository;

	public List<Aluguel> findAll() {
		return repository.findAll();
	}

	public Aluguel findById(Long id) {
		Optional<Aluguel> obj = repository.findById(id);
		return obj.get();
	}
}
