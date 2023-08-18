package com.solutis.desafiolocadora.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_apolice")
public class ApoliceSeguro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Valor da franquia da apólice não pode ser nulo")
	@Positive(message = "Valor da franquia da apólice deve ser positivo")
	private BigDecimal valorFranquia;
	
	@NotNull(message = "A proteção de terceiros não pode ser nula")
	private boolean protecaoTerceiro;
	
	@NotNull(message = "A proteção contra causas naturais não pode ser nula")
	private boolean protecaoCausasNaturais;
	
	@NotNull(message = "A proteção contra roubo não pode ser nula")
	private boolean ProtecaoRoubo;
	
	@JsonIgnore
	@OneToOne(mappedBy = "apolice")
	private Aluguel aluguel;
	
	public ApoliceSeguro() {
	}

	public ApoliceSeguro(Long id, BigDecimal valorFranquia, boolean protecaoTerceiro, boolean protecaoCausasNaturais, boolean protecaoRoubo) {
		this.id = id;
		this.valorFranquia = valorFranquia;
		this.protecaoTerceiro = protecaoTerceiro;
		this.protecaoCausasNaturais = protecaoCausasNaturais;
		ProtecaoRoubo = protecaoRoubo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorFranquia() {
		return valorFranquia;
	}

	public void setValorFranquia(BigDecimal valorFranquia) {
		this.valorFranquia = valorFranquia;
	}

	public boolean isProtecaoTerceiro() {
		return protecaoTerceiro;
	}

	public void setProtecaoTerceiro(boolean protecaoTerceiro) {
		this.protecaoTerceiro = protecaoTerceiro;
	}

	public boolean isProtecaoCausasNaturais() {
		return protecaoCausasNaturais;
	}

	public void setProtecaoCausasNaturais(boolean protecaoCausasNaturais) {
		this.protecaoCausasNaturais = protecaoCausasNaturais;
	}

	public boolean isProtecaoRoubo() {
		return ProtecaoRoubo;
	}

	public void setProtecaoRoubo(boolean protecaoRoubo) {
		ProtecaoRoubo = protecaoRoubo;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApoliceSeguro other = (ApoliceSeguro) obj;
		return Objects.equals(id, other.id);
	}
}
