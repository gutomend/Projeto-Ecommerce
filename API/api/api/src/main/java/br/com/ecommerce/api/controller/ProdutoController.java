package br.com.ecommerce.api.controller;


import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;
import br.com.ecommerce.api.service.ClienteService;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ClienteService clienteService;
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoService service, ClienteService clienteService, ProdutoRepository produtoRepository) {
        produtoService = service;
        this.clienteService = clienteService;
        this.produtoRepository = produtoRepository;
    }
@GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        List<Produto> produtos = produtoService.listarTodos();

        return ResponseEntity.ok(produtos);
    }
    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(
            @RequestBody Produto produto
    ){
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){

        Produto produto = produtoService.buscarPorId(id);

        if (produto != null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto" + id + "Não encontrado");
        }
        return ResponseEntity.ok(produto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Integer id){

        Produto produto = produtoService.deletarProduto(id);

        if (produto != null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente" + id + "Não encontrado");
        }

        produtoRepository.delete(produto);
        return ResponseEntity.ok(produto);
    }
}














