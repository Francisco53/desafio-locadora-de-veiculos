package com.solutis.desafiolocadora.entities;

import java.time.LocalDate;

import com.solutis.desafiolocadora.enumeration.Sexo;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Pattern(regexp = "\\d{4,6}")
	private String matricula;

	public Funcionario() {
	}

	public Funcionario(Long id, String nome, LocalDate dataNascimento, String cpf, String email, Sexo sexo, String matricula) {
		super(id, nome, dataNascimento, cpf, email, sexo);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
