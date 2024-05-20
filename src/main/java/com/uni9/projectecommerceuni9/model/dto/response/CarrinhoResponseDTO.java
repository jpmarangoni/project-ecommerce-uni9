package com.uni9.projectecommerceuni9.model.dto.response;

import com.uni9.projectecommerceuni9.model.dto.LivroRecordDto;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CarrinhoResponseDTO(
        Long id,
        @NotNull Integer quantidade,
        @NotNull List<LivroRecordDto> livros,
        String statusCarrinho
        //TODO: Criar classe de response para retornar objeto sem o pedido ou retornar void no Post
) {}
