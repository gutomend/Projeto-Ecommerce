package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import br.com.ecommerce.api.service.ClienteService;
import org.springdoc.core.service.GenericResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    //Controler -> Service
    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;
    private final GenericResponseService responseBuilder;

    public ClienteController(ClienteService service, ClienteRepository clienteRepository, GenericResponseService responseBuilder) {
        clienteService = service;
        this.clienteRepository = clienteRepository;
        this.responseBuilder = responseBuilder;
    }

    //Listar Todos
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        //1. Pegar a lista de Cliente
        List<Cliente> clientes = clienteService.listarTodos();

        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(
            @RequestBody Cliente cliente
    ) {
        //1. TENTAR CADASTRAR O CLIENTE
        clienteService.cadastrarCliente(cliente);

        //CODIGO 200 - OK
        //return ResponseEntity.ok(cliente);
        //CODIGO 201 - CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    //BUSCAR CLIENTE POR ID
    //GET, POST, PUT, DELETE
    @GetMapping("/{id}")
    //PathVariable recebe um valor no link
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {

        //1. Procurar e guardar o Cliente
        Cliente cliente = clienteService.buscarPorId(id);

        //2. Se não encontrar, retorno um erro
        if (cliente == null) {
            //Mais simples
            //return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente" + id + "Não encontrado");
        }

        //3. Se encontrar, retorno o Cliente
        return ResponseEntity.ok(cliente);
    }

    //GET, POST, PUT, DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Integer id) {
        //1. Verificar se o cliente existe
        Cliente cliente = clienteService.deletarCliente(id);

        //2. Se não existir, retorno erro
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente" + id + "Não encontrado");
        }

        //3. Se existir, retorno ok
        clienteRepository.delete(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(
            @PathVariable Integer id, @RequestBody Cliente clienteNovo) {
        //1.Tento atualizar o cliente
        Cliente cl = clienteService.atualizarCliente(id, clienteNovo);

        //2.
        if (cl == null) {
            return ResponseEntity.status(404)
                    .body("Cliente nao encontrado");
        }
        //3.Se achar retorno ok
        return ResponseEntity.ok(cl);
    }
}