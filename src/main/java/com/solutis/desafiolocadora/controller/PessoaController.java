package com.solutis.desafiolocadora.controller;

import com.solutis.desafiolocadora.entities.Funcionario;
import com.solutis.desafiolocadora.entities.Motorista;
import com.solutis.desafiolocadora.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/cadastro")
public class PessoaController {

    @Autowired
    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping("/motorista/form")
    public ResponseEntity<Motorista> criarMotorista(@RequestBody @Valid Motorista motorista) {
        Motorista novoMotorista = (Motorista) service.salvarPessoa(motorista);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novoMotorista.getId()).toUri();
        return ResponseEntity.created(uri).body(novoMotorista);
    }



    @PostMapping("/funcionario/form")
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody @Valid Funcionario funcionario) {
        Funcionario novoFuncionario = (Funcionario) service.salvarPessoa(funcionario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novoFuncionario.getId()).toUri();
        return ResponseEntity.created(uri).body(novoFuncionario);
    }

}
