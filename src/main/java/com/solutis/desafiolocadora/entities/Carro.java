package com.solutis.desafiolocadora.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_carro")
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Placa do veículo não pode ser vazia")
	private String placa;
	
	@NotBlank(message = "Chassi do veículo não pode ser vazia")
	private String chassi;
	
	@NotBlank(message = "Cor do veículo não pode ser vazia")
	private String cor;
	
	@NotBlank(message = "A URL da imagem do veículo não pode ser vazia")
	private String imgUrl;
	
	@NotNull(message = "Valor da diária do veículo não pode ser nulo")
	@Positive(message = "Valor da diária do veículo deve ser positivo")
	private BigDecimal valorDiaria;
	
	@ManyToMany
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Acessorio> acessorios = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "modelo_id")
	private ModeloCarro modelo;
	
	public Carro() {
	}

	public Carro(Long id, String placa, String chassi, String cor, String imgUrl, BigDecimal valorDiaria, ModeloCarro modelo) {
		this.id = id;
		this.placa = placa;
		this.chassi = chassi;
		this.cor = cor;
		this.imgUrl = imgUrl;
		this.valorDiaria = valorDiaria;
		this.modelo = modelo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	public Set<Acessorio> getAcessorios() {
		return acessorios;
	}

	public ModeloCarro getModelo() {
		return modelo;
	}

	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
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
		Carro other = (Carro) obj;
		return Objects.equals(id, other.id);
	}
}
