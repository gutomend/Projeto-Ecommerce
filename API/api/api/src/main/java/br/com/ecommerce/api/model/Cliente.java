package br.com.ecommerce.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente", schema = "techmarket")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", nullable = false)
    private Integer id;

    @Column(name = "nome_completo", nullable = false, length = Integer.MAX_VALUE)
    private String nomeCompleto;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "senha", nullable = false, length = Integer.MAX_VALUE)
    private String senha;

    @Column(name = "telefone", nullable = false)
    private Integer telefone;

}