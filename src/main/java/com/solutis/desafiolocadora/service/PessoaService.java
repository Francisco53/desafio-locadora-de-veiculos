package com.solutis.desafiolocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.Pessoa;
import com.solutis.desafiolocadora.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public PessoaService(PessoaRepository repository) {
		this.repository = repository;
	}

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return repository.save(pessoa);
	}

}
