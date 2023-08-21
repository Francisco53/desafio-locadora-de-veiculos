package com.solutis.desafiolocadora.entities.enumerations;

public enum Categoria {

	HATCH_COMPACTO(1),
	HATCH_MEDIO(2),
	SEDAN_COMPACTO(3),
	SEDAN_MEDIO(4),
	SEDAN_GRANDE(5),
	MINIVAN(6),
	ESPORTIVO(7),
	UTILITARIO_COMERCIAL(8);

	private int code;

	private Categoria(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static Categoria valueOf(int code) {
		for (Categoria value : Categoria.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido da Categoria");
	}
}
