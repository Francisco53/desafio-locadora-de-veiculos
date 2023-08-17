package com.solutis.desafiolocadora.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_aluguel")
public class Aluguel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Data do pedido não pode ser nula")
	private Calendar dataPedido;

	@NotNull(message = "Data de entrega não pode ser nula")
	@Future(message = "Data de entrega deve estar no futuro")
	private LocalDate dataEnterga;

	@NotNull(message = "Data de devolução não pode ser nula")
	@Future(message = "Data de devolução deve estar no futuro")
	private LocalDate dataDevolucao;

	@NotNull(message = "Valor total não pode ser nulo")
	@Positive(message = "Valor total deve ser positivo")
	private BigDecimal valorTotal;

	@OneToOne
	@JoinColumn(name = "apolice_seguro_id")
	private ApoliceSeguro apolice;

	@ManyToOne
	@JoinColumn(name = "motorista_id")
	private Motorista motorista;

	public Aluguel() {
	}

	public Long getId() {
		return id;
	}

	public Aluguel(Long id, Calendar dataPedido, LocalDate dataEnterga, LocalDate dataDevolucao, BigDecimal valorTotal, ApoliceSeguro apolice, Motorista motorista) {
		this.id = id;
		this.dataPedido = dataPedido;
		this.dataEnterga = dataEnterga;
		this.dataDevolucao = dataDevolucao;
		this.valorTotal = valorTotal;
		this.apolice = apolice;
		this.motorista = motorista;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEnterga() {
		return dataEnterga;
	}

	public void setDataEnterga(LocalDate dataEnterga) {
		this.dataEnterga = dataEnterga;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ApoliceSeguro getApoliceSeguro() {
		return apolice;
	}

	public void setApoliceSeguro(ApoliceSeguro apolice) {
		this.apolice = apolice;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
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
		Aluguel other = (Aluguel) obj;
		return Objects.equals(id, other.id);
	}
}
