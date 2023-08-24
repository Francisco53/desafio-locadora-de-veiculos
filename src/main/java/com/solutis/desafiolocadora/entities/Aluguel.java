package com.solutis.desafiolocadora.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import jakarta.validation.constraints.FutureOrPresent;
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
	@FutureOrPresent(message = "Data de entrega deve estar no futuro")
	private LocalDate dataEntrega;

	@NotNull(message = "Data de devolução não pode ser nula")
	@FutureOrPresent(message = "Data de devolução deve estar no futuro")
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
	
	@ManyToOne
	@JoinColumn(name = "carro_id")
	private Carro carro;

	public Aluguel() {
	}

	public Aluguel(Long id, Calendar dataPedido, LocalDate dataEntrega, LocalDate dataDevolucao, ApoliceSeguro apolice, Motorista motorista, Carro carro) {
		this.id = id;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataDevolucao = dataDevolucao;
		this.apolice = apolice;
		this.motorista = motorista;
		this.carro = carro;
		calcularValorTotal();
	}
	
	public Long getId() {
		return id;
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

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
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

	public void calcularValorTotal() {
        BigDecimal valorDiaria = carro.getValorDiaria();
        BigDecimal valorApolice = apolice.getValorFranquia();

        long quantidadeDeDias = ChronoUnit.DAYS.between(dataEntrega, dataDevolucao);

        BigDecimal valorTotalDiarias = valorDiaria.multiply(BigDecimal.valueOf(quantidadeDeDias));
        BigDecimal valorTotal = valorTotalDiarias.add(valorApolice);

        this.valorTotal = valorTotal;
    }

	public ApoliceSeguro getApolice() {
		return apolice;
	}

	public void setApolice(ApoliceSeguro apolice) {
		this.apolice = apolice;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
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
