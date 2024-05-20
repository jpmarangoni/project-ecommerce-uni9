package com.uni9.projectecommerceuni9.model.dto;

import com.uni9.projectecommerceuni9.model.PedidoModel;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CarrinhoRecordDTO(
        Long id,
        @NotNull Integer quantidade,
        @NotNull List<LivroRecordDto> livros,
        String statusCarrinho,
        PedidoModel pedido
        //TODO: Criar classe de response para retornar objeto sem o pedido ou retornar void no Post
) {}