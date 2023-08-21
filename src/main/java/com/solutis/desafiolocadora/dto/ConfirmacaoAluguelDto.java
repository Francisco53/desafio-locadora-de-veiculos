package com.solutis.desafiolocadora.dto;

import com.solutis.desafiolocadora.entities.enumerations.MetodoPagamento;

public class ConfirmacaoAluguelDto {

	private boolean concordouTermos;
	private MetodoPagamento metodoPagamento;

	public boolean isConcordouTermos() {
		return concordouTermos;
	}

	public String getMetodoPagamento() {
		return metodoPagamento.getDescricao();
	}
}
