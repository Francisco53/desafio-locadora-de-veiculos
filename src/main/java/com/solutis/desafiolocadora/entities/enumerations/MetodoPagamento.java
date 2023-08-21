package com.solutis.desafiolocadora.entities.enumerations;

public enum MetodoPagamento {
	
	CARTAO_CREDITO("Cartão de Crédito"),
	CARTAO_DEBITO("Cartão de Débito"),
	BOLETO_BANCARIO("Boleto Bancário");

	private final String descricao;

	MetodoPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
