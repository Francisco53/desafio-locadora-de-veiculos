package com.solutis.desafiolocadora.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ItemCarrinho {

	private Carro carro;
	private Motorista motorista;
	private ApoliceSeguro apolice;
	private LocalDate dataEntrega;
	private LocalDate dataDevolucao;
	private BigDecimal subtotal;

	public ItemCarrinho(Carro carro, Motorista motorista, ApoliceSeguro apolice, LocalDate dataEntrega, LocalDate dataDevolucao) {
		this.carro = carro;
		this.motorista = motorista;
		this.apolice = apolice;
		this.dataEntrega = dataEntrega;
		this.dataDevolucao = dataDevolucao;
		this.carro.getAcessorios().size();
		this.subtotal = calcularSubtotal();
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public ApoliceSeguro getApolice() {
		return apolice;
	}

	public void setApolice(ApoliceSeguro apolice) {
		this.apolice = apolice;
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

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public BigDecimal calcularSubtotal() {
		BigDecimal valorDiaria = getCarro().getValorDiaria();
		long diasAluguel = ChronoUnit.DAYS.between(getDataEntrega(), getDataDevolucao());

		BigDecimal subtotalDiaria = valorDiaria.multiply(BigDecimal.valueOf(diasAluguel));
		BigDecimal valorApolice = getApolice() != null ? getApolice().getValorFranquia() : BigDecimal.ZERO;

		subtotal = subtotalDiaria.add(valorApolice);
		
		return getSubtotal();
	}
}
