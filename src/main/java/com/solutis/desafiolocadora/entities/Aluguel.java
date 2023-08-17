package com.solutis.desafiolocadora.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

public class Aluguel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Calendar dataPedido;
	private LocalDate dataEnterga;
	private LocalDate dataDevolucao;
	private BigDecimal valorTotal;
}
