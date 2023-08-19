package com.solutis.desafiolocadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.Acessorio;
import com.solutis.desafiolocadora.entities.Carro;
import com.solutis.desafiolocadora.repositories.CarroRepository;
import com.solutis.desafiolocadora.services.exceptions.ResourceNotFoundException;

@Service
public class CarroService {

	@Autowired
	private CarroRepository repository;

	public List<Carro> findAll() {
		return repository.findAll();
	}

	public Carro findById(Long id) {
		Optional<Carro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Carro insert(Carro obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Carro update(Long id, Carro obj) {
		Carro entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	public void updateData(Carro entity, Carro obj) {
		entity.setPlaca(obj.getPlaca());
		entity.setChassi(obj.getChassi());
		entity.setCor(obj.getCor());
		entity.setImgUrl(obj.getImgUrl());
		entity.setValorDiaria(obj.getValorDiaria());
		for (Acessorio acessorio : obj.getAcessorios()) {
			entity.addAcessorio(acessorio);
		}
		entity.setModelo(obj.getModelo());
	}
}
