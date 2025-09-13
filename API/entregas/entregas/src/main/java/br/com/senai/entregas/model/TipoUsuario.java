package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//----------------------Lombok-------------------//
@Getter
@Setter

//OBRIGATORIO PARA JPA FUNCIONAR (Sem ele os dados ficarao nulos)
@NoArgsConstructor
//OPCIONAL
@AllArgsConstructor

//-----------------------JPA----------------------//
//Entity infotma que essa classe é uma tabela
@Entity
//Permite que seja configurada a tabela
@Table(name = "tipo_usuario")

public class TipoUsuario {

    //Representacao das colunas da tabela
    // @ID Define quem é chave primaria
    @Id
    //GeneratedValue Define que a chave é gerenciada pelo DB
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Column configura a coluna
    //name nome da coluna
    //nulable se pode ser nulo ou nao
    @Column(name = "tipo_usuario_id", nullable = false)
    private Integer tipoUsuarioId;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;
}
