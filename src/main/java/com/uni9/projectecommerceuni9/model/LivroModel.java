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
    @Column(name = "id")
    Long id;

    @Column(name = "titulo")
    String titulo;

    @Column(name = "linkImagem")
    String linkImagem;

    @Column(name = "numeroPaginas")
    String numeroPaginas;

    @Column(name = "idioma")
    String idioma;

    @Column(name = "editora")
    String editora;

    @Column(name = "autor")
    String autor;

    @Column(name = "descricao")
    String descricao;

    @Column(name = "anoEdicao")
    String anoEdicao;

    @Column(name = "preco")
    String preco;
}
