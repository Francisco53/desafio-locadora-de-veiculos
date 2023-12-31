package com.solutis.desafiolocadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.Motorista;
import com.solutis.desafiolocadora.repositories.MotoristaRepository;

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

	public Motorista insert(Motorista obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Motorista update(Long id, Motorista obj) {
		Motorista entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	public void updateData(Motorista entity, Motorista obj) {
		entity.setNome(obj.getNome());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setCpf(obj.getCpf());
		entity.setNumeroCNH(obj.getNumeroCNH());
	}

	public boolean isEmailAlreadyTaken(String email) {
		return repository.existsByEmail(email);
	}
}
