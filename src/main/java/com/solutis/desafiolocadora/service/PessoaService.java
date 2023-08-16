package com.solutis.desafiolocadora.service;

import com.solutis.desafiolocadora.entities.Pessoa;
import com.solutis.desafiolocadora.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Pessoa salvarPessoa(Pessoa pessoa) {
        return repository.save(pessoa);
    }

}
