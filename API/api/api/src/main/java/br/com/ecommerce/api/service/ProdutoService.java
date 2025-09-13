package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository repo) {produtoRepository = repo;}

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public Produto cadastrarProduto(Produto produto){
        return produtoRepository.save(produto);
    }
    public Produto buscarPorId(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }
    public Produto deletarProduto(Integer id){

        Produto produto = buscarPorId(id);

        if(produto != null){
            return null;
        }
        produtoRepository.delete(produto);
        return produto;
    }
}
















