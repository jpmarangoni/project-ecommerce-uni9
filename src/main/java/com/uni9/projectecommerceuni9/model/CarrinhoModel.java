package com.uni9.projectecommerceuni9.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CARRINHO")
public class CarrinhoModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "quantidade")
  private Integer quantidade;

  @OneToMany
  @JoinColumn(name = "livros", referencedColumnName = "id")
  private List<LivroModel> livros;

  @OneToOne(mappedBy = "carrinho", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
  @JoinColumn(name = "cliente_id", referencedColumnName = "id")
  private ClienteModel cliente;

  @Column(name = "status_carrinho")
  private String statusCarrinho;

//  @ManyToOne(cascade = CascadeType.PERSIST)
//  @JoinColumn(referencedColumnName = "id")
//  private PedidoModel pedido;
}
