package com.uni9.projectecommerceuni9.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column
    String titulo;

    @NotNull
    @Column
    String linkImagem;

    @NotNull
    @Column
    String numeroPaginas;

    @NotNull
    @Column
    String idioma;

    @NotNull
    @Column
    String editora;

    @NotNull
    @Column
    String autor;

    @NotNull
    @Column
    String descricao;

    @NotNull
    @Column
    String anoEdicao;

    @NotNull
    @Column
    String preco;
}
