package com.uni9.projectecommerceuni9.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PEDIDO")
public class PedidoModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne
    private ClienteModel cliente;

    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "data_pedido")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataPedido;

    @OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST)
    @Column(name = "itens_carrinho")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CarrinhoModel> itensCarrinho;

    @Column(name = "status_pedido")
    private String statusPedido;

    @Column(name = "valor_total")
    private Double valorTotal;
}
