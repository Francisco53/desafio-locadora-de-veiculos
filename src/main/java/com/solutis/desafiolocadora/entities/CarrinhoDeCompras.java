package com.solutis.desafiolocadora.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<ItemCarrinho> itens = new ArrayList<>();
    
    private ApoliceSeguro apolice;

    public void adicionarItem(ItemCarrinho item) {
        itens.add(item);
        item.calcularSubtotal();
    }
    
    public ApoliceSeguro getApolice() {
        return apolice;
    }

    public void setApolice(ApoliceSeguro apolice) {
        this.apolice = apolice;
    }

    public void removerItem(int index) {
        if (index >= 0 && index < itens.size()) {
            itens.remove(index);
        }
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public void limparCarrinho() {
        itens.clear();
    }

    public BigDecimal calcularTotal() {
        return itens.stream()
                .map(ItemCarrinho::calcularSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
