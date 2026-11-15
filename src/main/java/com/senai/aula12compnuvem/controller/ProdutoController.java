package com.senai.aula12compnuvem.controller;

import com.senai.aula12compnuvem.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final List<Produto> produtos = new ArrayList<>(List.of(
            new Produto(1L, "Notebook", new BigDecimal("4500.00")),
            new Produto(2L, "Mouse", new BigDecimal("100.00")),
            new Produto(3L, "Teclado", new BigDecimal("250.00"))
    ));

    @GetMapping
    public List<Produto> listar() {
        return List.copyOf(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        produtos.add(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto dados) {
        for (Produto produto : produtos) {
            if (id.equals(produto.getId())) {
                produto.setNome(dados.getNome());
                produto.setPreco(dados.getPreco());
                return ResponseEntity.ok(produto);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean removido = produtos.removeIf(produto -> id.equals(produto.getId()));
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
