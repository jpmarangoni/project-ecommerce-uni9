package com.uni9.projectecommerceuni9.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CLIENTE")
@Entity(name = "TB_CLIENTE")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "logradouro")
//    @JoinColumn(name = "endereco", referencedColumnName = "logradouro")
    private List<EnderecoModel> endereco;

    @OneToMany(mappedBy = "telefone")
//    @JoinColumn(name = "telefone", referencedColumnName = "telefone")
    private List<TelefoneModel> telefones;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cnpj")
    private String cnpj;

}
