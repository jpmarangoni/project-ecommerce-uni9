package com.uni9.projectecommerceuni9.model.dto;

import com.uni9.projectecommerceuni9.model.ClienteModel;
import com.uni9.projectecommerceuni9.model.ItemCarrinho;
import com.uni9.projectecommerceuni9.model.PedidoModel;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CarrinhoRecordDTO(
        Long id,
        @NotNull List<ItemCarrinho> itens,
        @NotNull ClienteModel clienteId,
        PedidoModel pedido,
        String statusCarrinho
        //TODO: Criar classe de response para retornar objeto sem o pedido ou retornar void no Post
) {}