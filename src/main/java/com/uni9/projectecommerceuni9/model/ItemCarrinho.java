package com.uni9.projectecommerceuni9.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_ITEM_CARRINHO")
public class ItemCarrinho {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "livro", referencedColumnName = "id")
    private LivroModel livroId;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "carrinho", referencedColumnName = "id")
    private CarrinhoModel carrinhoId;

    @Column(name = "quantidade")
    private Integer quantidade;
}
