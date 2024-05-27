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
@Table(name = "TB_CLIENTE")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
//    @LazyCollection(LazyCollectionOption.FALSE)
    private List<EnderecoModel> enderecos;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
//    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TelefoneModel> telefones;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "tipo_cliente")
    private String tipoCliente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrinho_id", referencedColumnName = "id")
    private CarrinhoModel carrinho;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private List<PedidoModel> pedido;

    public ClienteModel(Long id){
        this.id = id;
    }
}
