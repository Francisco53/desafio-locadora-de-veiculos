package com.solutis.desafiolocadora.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.desafiolocadora.dto.ConfirmacaoAluguelDto;
import com.solutis.desafiolocadora.dto.ItemCarrinhoDto;
import com.solutis.desafiolocadora.entities.Aluguel;
import com.solutis.desafiolocadora.entities.ApoliceSeguro;
import com.solutis.desafiolocadora.entities.CarrinhoDeCompras;
import com.solutis.desafiolocadora.entities.Carro;
import com.solutis.desafiolocadora.entities.ItemCarrinho;
import com.solutis.desafiolocadora.entities.Motorista;
import com.solutis.desafiolocadora.util.ResponseMessage;

@Service
public class CarrinhoDeComprasService {

	private final CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

	@Autowired
	private MotoristaService motoristaService;

	@Autowired
	private ApoliceSeguroService apoliceService;

	@Autowired
	private CarroService carroService;

	@Autowired
	private AluguelService aluguelService;

	public CarrinhoDeCompras getCarrinho() {
		return carrinhoDeCompras;
	}

	public ResponseMessage adicionarItem(ItemCarrinhoDto itemDto) {
		Carro carro = carroService.findById(itemDto.getCarroId());
		if (carro == null) {
			return new ResponseMessage("Carro não encontrado.");
		}

		ItemCarrinho itemExistente = carrinhoDeCompras.getItemByCarroId(carro.getId());
		if (itemExistente != null) {
			if (!isCarroDisponivel(carro, itemDto.getDataEntrega(), itemDto.getDataDevolucao())) {
				return new ResponseMessage("Carro não está disponível nesse período.");
			}

			itemExistente.setDataEntrega(itemDto.getDataEntrega());
			itemExistente.setDataDevolucao(itemDto.getDataDevolucao());
			itemExistente.setApolice(apoliceService.findById(itemDto.getApoliceId()));
			itemExistente.calcularSubtotal();

			carrinhoDeCompras.atualizarItem(carrinhoDeCompras.getItens().indexOf(itemExistente), itemExistente);

			return new ResponseMessage("Item atualizado no carrinho com sucesso.");
		}

		if (!isCarroDisponivel(carro, itemDto.getDataEntrega(), itemDto.getDataDevolucao())) {
			return new ResponseMessage("Carro não está disponível nesse período.");
		}

		ItemCarrinho item = criarItemAPartirDoDto(itemDto);
		carrinhoDeCompras.adicionarItem(item);
		return new ResponseMessage("Item adicionado ao carrinho com sucesso.");
	}

	public ResponseMessage removerItem(int index) {
		carrinhoDeCompras.removerItem(index);
		return new ResponseMessage("Item removido do carrinho com sucesso.");
	}

	public ResponseMessage limparCarrinho() {
		carrinhoDeCompras.limparCarrinho();
		return new ResponseMessage("Carrinho de compras limpo com sucesso.");
	}

	public ResponseMessage calcularTotal() {
		BigDecimal total = carrinhoDeCompras.getValorTotal();
		return new ResponseMessage("Total do carrinho: " + total.toString());
	}

	public ResponseMessage confirmarAluguel(ConfirmacaoAluguelDto confirmacaoDto) {
		if (!confirmacaoDto.isConcordouTermos()) {
			return new ResponseMessage("Você deve concordar com os termos para confirmar o aluguel.");
		}

		if (carrinhoDeCompras.getItens().isEmpty()) {
			return new ResponseMessage("Carrinho de compras vazio. Não é possível confirmar o aluguel.");
		}

		salvarAlugueisDosItensNoCarrinho();

		carrinhoDeCompras.limparCarrinho();

		return new ResponseMessage("Aluguel confirmado com sucesso. Detalhes de pagamento: " + confirmacaoDto.getMetodoPagamento());
	}

	private ItemCarrinho criarItemAPartirDoDto(ItemCarrinhoDto itemDto) {
		Carro carro = carroService.findById(itemDto.getCarroId());
		Motorista motorista = motoristaService.findById(itemDto.getMotoristaId());
		ApoliceSeguro apolice = apoliceService.findById(itemDto.getApoliceId());

		return new ItemCarrinho(carro, motorista, apolice, itemDto.getDataEntrega(), itemDto.getDataDevolucao());
	}

	private void salvarAlugueisDosItensNoCarrinho() {
		List<ItemCarrinho> itens = carrinhoDeCompras.getItens();
		for (ItemCarrinho item : itens) {
			Aluguel aluguel = criarAluguelAPartirDoItem(item);
			aluguelService.insert(aluguel);
		}
	}

	private Aluguel criarAluguelAPartirDoItem(ItemCarrinho item) {
		return new Aluguel(null, Calendar.getInstance(), item.getDataEntrega(), item.getDataDevolucao(), item.getApolice(), item.getMotorista(), item.getCarro());
	}

	private boolean isCarroDisponivel(Carro carro, LocalDate dataEntrega, LocalDate dataDevolucao) {
		Aluguel aluguelConflitante = aluguelService.findByCarroAndDates(carro, dataEntrega, dataDevolucao);
		return aluguelConflitante == null;
	}
}
