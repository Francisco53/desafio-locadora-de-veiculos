package com.solutis.desafiolocadora.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solutis.desafiolocadora.entities.enumerations.Categoria;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_modelo")
public class ModeloCarro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Descrição não pode ser vazia")
    private String descricao;
    
    @NotNull(message = "Categoria não pode ser vazia")
    private Integer categoria;
    
    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;
    
    @JsonIgnore
    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Carro> carros = new HashSet<>();
    
    public ModeloCarro() {
    }

	public ModeloCarro(Long id, String descricao, Categoria categoria, Fabricante fabricante) {
		this.id = id;
		this.descricao = descricao;
		setCategoria(categoria);
		this.fabricante = fabricante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		if (categoria == null) {
			return null;
		}
		return Categoria.valueOf(categoria);
	}

	public void setCategoria(Categoria categoria) {
		if (categoria != null) {
			this.categoria = categoria.getCode();
		}
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Set<Carro> getCarros() {
		return carros;
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
		ModeloCarro other = (ModeloCarro) obj;
		return Objects.equals(id, other.id);
	}
}
