package com.solutis.desafiolocadora.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

public class Aluguel {

    private Calendar dataPedido;
    private LocalDate dataEnterga;
    private LocalDate dataDevolucao;
    private BigDecimal valorTotal;
}
