package com.uni9.projectecommerceuni9.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_LIVRO")
@Entity(name = "TB_LIVRO")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String titulo;

    @Column
    String linkImagem;

    @Column
    String numeroPaginas;

    @Column
    String idioma;

    @Column
    String editora;

    @Column
    String autor;

    @Column
    String descricao;

    @Column
    String anoEdicao;

    @Column
    Double preco;
}
