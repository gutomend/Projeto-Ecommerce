package br.com.senai.entregas.service;


import br.com.senai.entregas.model.Endereco;
import br.com.senai.entregas.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository repo) {enderecoRepository= repo;}

    public List<Endereco> lisarTodos(){return enderecoRepository.findAll();}
}
