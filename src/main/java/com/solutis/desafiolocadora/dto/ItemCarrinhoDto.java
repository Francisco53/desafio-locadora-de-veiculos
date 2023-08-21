package com.solutis.desafiolocadora.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

public class ItemCarrinhoDto {

	@NotNull
	private Long motoristaId;

	@NotNull
	private Long carroId;

	@NotNull
	private Long apoliceId;

	@NotNull
	private LocalDate dataEntrega;

	@NotNull
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
	
	@AssertTrue(message = "A data de devolução deve ser igual ou posterior à data de entrega")
    private boolean isDataDevolucaoMaiorOuIgualDataEntrega() {
        return dataDevolucao == null || dataEntrega == null || !dataDevolucao.isBefore(dataEntrega);
    }
}
