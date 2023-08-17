package com.solutis.desafiolocadora.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solutis.desafiolocadora.enumeration.Sexo;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_motorista")
public class Motorista extends Pessoa {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Número da CNH não pode ser vazio")
	@Size(min = 11, max = 11)
	@Pattern(regexp = "[0-9]+")
	private String numeroCNH;
	
	@JsonIgnore
	@OneToMany(mappedBy = "motorista")
	private List<Aluguel> alugueis = new ArrayList<>();

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

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}
}
