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
    Long id;

    @Column(name = "nome")
    String nome;

    @OneToOne
    @JoinColumn(name = "endereco", referencedColumnName = "endereco")
    EnderecoModel endereco;

    @OneToMany
    @JoinColumn(name = "telefones", referencedColumnName = "telefone")
    List<TelefoneModel> telefones;

    @Column(name = "email")
    String email;

    @Column(name = "cpf")
    String cpf;

    @Column(name = "cnpj")
    String cnpj;

}
