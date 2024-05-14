package com.uni9.projectecommerceuni9.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_ENDERECO")
public class EnderecoModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_endereco")
  private Long id;

  @NotBlank
  @Column(name = "logradouro")
  private String logradouro;

  @NotBlank
  @Column(name = "mumero")
  private String numero;

  @Column(name = "complemento")
  private String complemento;

  @NotBlank
  @Column(name = "cidade")
  private String cidade;

  @NotBlank
  @Column(name = "cep")
  private String cep;

  @NotBlank
  @Column(name = "bairro")
  private String bairro;

  @NotBlank
  @Column(name = "uf")
  private String uf;

  @ManyToOne
  @JoinColumn(name = "clienteId", referencedColumnName = "id")
  private ClienteModel cliente;
}
