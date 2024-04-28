package com.uni9.projectecommerceuni9.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ENDERECO")
@Entity(name = "TB_ENDERECO")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "mumero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "cep")
    private String cep;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "uf")
    private String uf;
}
