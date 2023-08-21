package com.solutis.desafiolocadora.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.entities.Aluguel;
import com.solutis.desafiolocadora.entities.Carro;
import com.solutis.desafiolocadora.repositories.AluguelRepository;

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

	public Aluguel insert(Aluguel obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Aluguel update(Long id, Aluguel obj) {
		Aluguel entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	public void updateData(Aluguel entity, Aluguel obj) {
		entity.setMotorista(entity.getMotorista());
		entity.setApolice(obj.getApolice());
		entity.setCarro(obj.getCarro());
		entity.setDataPedido(obj.getDataPedido());
		entity.setDataEntrega(obj.getDataEntrega());
		entity.setDataDevolucao(obj.getDataDevolucao());
		entity.calcularValorTotal();
	}
	
	public Aluguel findByCarroAndDates(Carro carro, LocalDate dataEntrega, LocalDate dataDevolucao) {
        return repository.findByCarroAndDataEntregaLessThanEqualAndDataDevolucaoGreaterThanEqual(carro, dataEntrega, dataDevolucao);
    }
}
