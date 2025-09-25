package br.com.senai.entregas.service;


import br.com.senai.entregas.model.Entrega;
import br.com.senai.entregas.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {
    private final EntregaRepository entregaRepository;

    public EntregaService(EntregaRepository repo) {entregaRepository = repo;}

    public List<Entrega> lisarTodos(){return entregaRepository.findAll();}
}
