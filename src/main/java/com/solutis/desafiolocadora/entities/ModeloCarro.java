package com.solutis.desafiolocadora.entities;

import java.util.List;

import com.solutis.desafiolocadora.enumeration.Categoria;

public class ModeloCarro {
	
    private String descricao;
    private Categoria categoria;
    private Fabricante fabricante;
    private List<Carro> carros;
}
