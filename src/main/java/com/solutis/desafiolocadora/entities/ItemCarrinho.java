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

    public ItemCarrinho(Carro carro, Motorista motorista, ApoliceSeguro apolice, LocalDate dataEntrega, LocalDate dataDevolucao) {
        this.carro = carro;
        this.motorista = motorista;
        this.apolice = apolice;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
    }

    public BigDecimal calcularSubtotal() {
        return carro.getValorDiaria().multiply(BigDecimal.valueOf(ChronoUnit.DAYS.between(dataEntrega, dataDevolucao)));
    }

    public Carro getCarro() {
        return carro;
    }
    
    public Motorista getMotorista() {
		return motorista;
	}
    
    public ApoliceSeguro getApolice() {
		return apolice;
	}

	public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
}
