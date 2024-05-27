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

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "carrinho")
  private List<ItemCarrinho> itens;

  @OneToOne(fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn(name = "cliente_id", referencedColumnName = "id")
  private ClienteModel cliente;

  @OneToOne(fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn(name = "pedido_id", referencedColumnName = "id")
  private PedidoModel pedido;

  @Column(name = "status_carrinho")
  private String statusCarrinho;

  @Column(name = "valor_total")
  private Double valorTotal;
}
