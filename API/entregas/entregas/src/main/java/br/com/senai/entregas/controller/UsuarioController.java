package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.repository.UsuarioRepository;
import br.com.senai.entregas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")

public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioService service, UsuarioRepository usuarioRepository){
        usuarioService = service;
        this.usuarioRepository = usuarioRepository;
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuario(){
        List<Usuario> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(
            @RequestBody Usuario usuario) {
        usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuario(@PathVariable Integer id){
        Usuario usuario = usuarioService.buscarPorId(id);

        if (usuario == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario" + id + "Não encontrado");
    }
        return ResponseEntity.ok(usuario);
}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Integer id) {
        //1. Verificar se o usuario existe
        Usuario usuario = usuarioService.deletarUsuario(id);

        //2. Se não existir, retorno erro
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario" + id + "Não encontrado");
        }

        //3. Se existir, retorno ok
        usuarioRepository.delete(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(
            @PathVariable Integer id, @RequestBody Usuario usuarioNovo) {
        //1.Tento atualizar o usuario
        Usuario cl = usuarioService.atualizarUsuario(id, usuarioNovo);

        //2.
        if (cl == null) {
            return ResponseEntity.status(404)
                    .body("Usuario nao encontrado");
        }
        //3.Se achar retorno ok
        return ResponseEntity.ok(cl);
    }
}