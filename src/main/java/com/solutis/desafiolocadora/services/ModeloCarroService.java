package com.solutis.desafiolocadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.ModeloCarro;
import com.solutis.desafiolocadora.repositories.ModeloCarroRepository;
import com.solutis.desafiolocadora.services.exceptions.ResourceNotFoundException;

@Service
public class ModeloCarroService {

	@Autowired
	private ModeloCarroRepository repository;
	
	public List<ModeloCarro> findAll() {
		return repository.findAll();
	}
	
	public ModeloCarro findById(Long id) {
		Optional<ModeloCarro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public ModeloCarro insert(ModeloCarro obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public ModeloCarro update(Long id, ModeloCarro obj) {
		ModeloCarro entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	public void updateData(ModeloCarro entity, ModeloCarro obj) {
		entity.setDescricao(obj.getDescricao());
		entity.setCategoria(obj.getCategoria());;
		entity.setFabricante(obj.getFabricante());
		
	}
}
