package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Veiculo;
import br.com.senai.entregas.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository repo) {veiculoRepository= repo;}

    public List<Veiculo> listar(){return veiculoRepository.findAll();}
}
