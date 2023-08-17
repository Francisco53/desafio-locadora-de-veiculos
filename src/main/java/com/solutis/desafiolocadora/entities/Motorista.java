package com.solutis.desafiolocadora.entities;

import java.time.LocalDate;

import com.solutis.desafiolocadora.enumeration.Sexo;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Motorista extends Pessoa {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 11, max = 11)
	@Pattern(regexp = "[0-9]+")
	private String numeroCNH;

	public Motorista() {
	}

	public Motorista(Long id, String nome, LocalDate dataNascimento, String cpf, String email, Sexo sexo, String numeroCNH) {
		super(id, nome, dataNascimento, cpf, email, sexo);
		this.numeroCNH = numeroCNH;
	}

	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}
}
