package com.uni9.projectecommerceuni9.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_LIVRO")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "linkImagem")
    private String linkImagem;

    @Column(name = "numeroPaginas")
    private String numeroPaginas;

    @Column(name = "idioma")
    private String idioma;

    @Column(name = "editora")
    private String editora;

    @Column(name = "autor")
    private String autor;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "anoEdicao")
    private String anoEdicao;

    @Column(name = "preco")
    private Double preco;

    public LivroModel(Long id){
        this.id = id;
    }
}
