package com.solutis.desafiolocadora.dto;

import java.time.LocalDate;

public class ItemCarrinhoDto {

    private Long motoristaId;
    private Long carroId;
    private Long apoliceId;
    private LocalDate dataEntrega;
    private LocalDate dataDevolucao;

    public Long getMotoristaId() {
        return motoristaId;
    }

    public Long getCarroId() {
        return carroId;
    }

    public Long getApoliceId() {
        return apoliceId;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
}
