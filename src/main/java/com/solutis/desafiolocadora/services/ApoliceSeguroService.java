package com.solutis.desafiolocadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.ApoliceSeguro;
import com.solutis.desafiolocadora.repositories.ApoliceSeguroRepository;

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

	public ApoliceSeguro insert(ApoliceSeguro obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public ApoliceSeguro update(Long id, ApoliceSeguro obj) {
		ApoliceSeguro entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	public void updateData(ApoliceSeguro entity, ApoliceSeguro obj) {
		entity.setValorFranquia(obj.getValorFranquia());
		entity.setProtecaoTerceiro(obj.isProtecaoTerceiro());
		entity.setProtecaoCausasNaturais(obj.isProtecaoCausasNaturais());
		entity.setProtecaoRoubo(obj.isProtecaoRoubo());
	}
}
