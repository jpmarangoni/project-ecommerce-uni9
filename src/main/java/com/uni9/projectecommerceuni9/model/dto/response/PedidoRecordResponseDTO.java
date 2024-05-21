package com.uni9.projectecommerceuni9.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoRecordResponseDTO(
    Long id,
    @NotBlank Long clienteId,
    @NotNull @Valid List<CarrinhoResponseDTO> itensCarrinho,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    @NotBlank LocalDateTime dataPedido,
    @NotBlank String statusPedido,
    @NotBlank Double valorTotal) {}
