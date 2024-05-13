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
@EqualsAndHashCode(of = "id")
@Valid
@Entity
@Table(name = "TB_TELEFONE")
public class TelefoneModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_telefone")
  private Long id;

  @NotBlank
  @Column(name = "telefone")
  private String telefone;

  @ManyToOne
  @JoinColumn(name = "clienteId", referencedColumnName = "id")
  private ClienteModel cliente;
}
