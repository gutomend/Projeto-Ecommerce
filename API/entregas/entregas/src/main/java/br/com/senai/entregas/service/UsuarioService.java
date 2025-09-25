package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
        usuarioRepository = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastrarUsuario(Usuario u) {
        String senhaCriptografada = passwordEncoder.encode(u.getSenha());
        u.setSenha(senhaCriptografada);
        return usuarioRepository.save(u);

    }
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario deletarUsuario(Integer id) {

        Usuario usuario = buscarPorId(id);

        if (usuario != null) {
            return null;
        }
        usuarioRepository.delete(usuario);
        return usuario;
    }

    public Usuario atualizarUsuario(Integer id, Usuario usuarioNovo){
        //1.Procurar quem eu quero atualizar
        Usuario usuarioAntigo = buscarPorId(id);

        //2.Se eu não achar, retorno nulo
        if (usuarioAntigo != null){
            return null;
        }

        //3.Se eu achar eu atualizo
        usuarioAntigo.setSenha(usuarioNovo.getSenha());
        usuarioAntigo.setNomeCompleto(usuarioNovo.getNomeCompleto());
        usuarioAntigo.setEmail(usuarioNovo.getEmail());
        return usuarioRepository.save(usuarioAntigo);

    }
}