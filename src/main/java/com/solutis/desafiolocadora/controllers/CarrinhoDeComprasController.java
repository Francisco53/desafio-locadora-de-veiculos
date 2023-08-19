package com.solutis.desafiolocadora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.desafiolocadora.dto.ItemCarrinhoDto;
import com.solutis.desafiolocadora.entities.CarrinhoDeCompras;
import com.solutis.desafiolocadora.services.CarrinhoDeComprasService;
import com.solutis.desafiolocadora.util.ResponseMessage;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoDeComprasController {

    @Autowired
    private CarrinhoDeComprasService carrinhoDeComprasService;

    @GetMapping
    public ResponseEntity<CarrinhoDeCompras> exibirCarrinho() {
        CarrinhoDeCompras carrinho = carrinhoDeComprasService.getCarrinho();
        return ResponseEntity.ok(carrinho);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<ResponseMessage> adicionarAoCarrinho(@RequestBody ItemCarrinhoDto itemDto) {
        ResponseMessage responseMessage = carrinhoDeComprasService.adicionarItem(itemDto);
        return ResponseEntity.ok(responseMessage);
    }

    @DeleteMapping("/remover")
    public ResponseEntity<ResponseMessage> removerDoCarrinho(@RequestParam int index) {
        ResponseMessage responseMessage = carrinhoDeComprasService.removerItem(index);
        return ResponseEntity.ok(responseMessage);
    }

    @PostMapping("/limpar")
    public ResponseEntity<ResponseMessage> limparCarrinho() {
        ResponseMessage responseMessage = carrinhoDeComprasService.limparCarrinho();
        return ResponseEntity.ok(responseMessage);
    }

    @GetMapping("/calcular-total")
    public ResponseEntity<ResponseMessage> calcularTotal() {
        ResponseMessage responseMessage = carrinhoDeComprasService.calcularTotal();
        return ResponseEntity.ok(responseMessage);
    }
}

