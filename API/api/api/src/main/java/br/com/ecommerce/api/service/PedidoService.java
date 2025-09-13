package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository repo) { pedidoRepository = repo; }

    public List<Pedido> listarTodos(){
        return pedidoRepository.findAll();
    }

    public Pedido cadastrarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    public Pedido buscarPorID(Integer id){
        return pedidoRepository.findById(id).orElse(null);
    }
    public Pedido deletarPedido(Integer id){

        Pedido pedido = buscarPorID(id);

        if (pedido != null) {
            return null;
        }

        pedidoRepository.delete(pedido);
        return pedido;

    }
}








































