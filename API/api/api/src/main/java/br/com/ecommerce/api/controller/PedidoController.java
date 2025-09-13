package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.PedidoRepository;
import br.com.ecommerce.api.service.PedidoService;
import org.springdoc.core.service.GenericResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;
    private final PedidoRepository pedidoRepository;
    private final GenericResponseService responseBuilder;

    public PedidoController(PedidoService service, PedidoRepository pedidoRepository, GenericResponseService responseBuilder) {
        pedidoService = service;
        this.pedidoRepository = pedidoRepository;
        this.responseBuilder = responseBuilder;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos(){
        List<Pedido> pedidos = pedidoService.listarTodos();

        return ResponseEntity.ok(pedidos);

    }

    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(
            @RequestBody Pedido pedido
    ){
        pedidoService.cadastrarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPedidoPorId(@PathVariable Integer id){

    Pedido pedido = pedidoService.buscarPorID(id);

    if (pedido == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pedido" + id + "Nao encontrado");
    }
    return ResponseEntity.ok(pedido);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedidoPorId(@PathVariable Integer id){

        Pedido pedido = pedidoService.deletarPedido(id);

        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido" + id + "NaoEncontrado");
        }
        pedidoRepository.delete(pedido);
        return ResponseEntity.ok(pedido);
    }
}