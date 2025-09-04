package br.com.ecommerce.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "pedido", schema = "techmarket")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data_pedido")
    private OffsetDateTime dataPedido;

    @Column(name = "valor_total", precision = 18, scale = 4)
    private BigDecimal valorTotal;

    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

}