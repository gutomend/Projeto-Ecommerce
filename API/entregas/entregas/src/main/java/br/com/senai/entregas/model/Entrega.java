package br.com.senai.entregas.model;

import br.com.senai.entregas.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entregas")


public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entregas_id", nullable = false)
    private Integer entrega;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Column(name = "descricao_produto", nullable = false)
    private String descricaoProduto;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "data_pedido", nullable = false)
    private OffsetDateTime dataPedido;
}
