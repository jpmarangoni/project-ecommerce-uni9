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
@Table(name = "TB_ITEM_PEDIDO")
public class CarrinhoModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "quantidade")
  private Integer quantidade;

  @OneToMany
  @JoinColumn(name = "livros", referencedColumnName = "id")
  private List<LivroModel> livros;

  @Column(name = "status_carrinho")
  private String statusCarrinho;

  @ManyToOne
  @JoinColumn(referencedColumnName = "id")
  private PedidoModel pedido;
}
