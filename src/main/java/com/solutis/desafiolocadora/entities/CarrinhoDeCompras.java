package com.solutis.desafiolocadora.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

	private List<ItemCarrinho> itens = new ArrayList<>();
	private BigDecimal valorTotal = BigDecimal.ZERO;

	public void adicionarItem(ItemCarrinho item) {
		itens.add(item);
		recalcularValorTotal();
	}

	public void removerItem(int index) {
		if (index >= 0 && index < itens.size()) {
			itens.remove(index);
			recalcularValorTotal();
		}
	}

	public void atualizarItem(int index, ItemCarrinho novoItem) {
		if (index >= 0 && index < itens.size()) {
			itens.set(index, novoItem);
			recalcularValorTotal();
		}
	}

	public List<ItemCarrinho> getItens() {
		return itens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void limparCarrinho() {
		itens.clear();
		valorTotal = BigDecimal.ZERO;
	}

	public ItemCarrinho getItemByCarroId(Long id) {
		return itens.stream().filter(item -> item.getCarro().getId().equals(id)).findFirst().orElse(null);
	}

	private void recalcularValorTotal() {
		valorTotal = BigDecimal.ZERO;
		for (ItemCarrinho item : itens) {
			BigDecimal subtotal = item.calcularSubtotal();
			valorTotal = valorTotal.add(subtotal);
		}
	}
}
