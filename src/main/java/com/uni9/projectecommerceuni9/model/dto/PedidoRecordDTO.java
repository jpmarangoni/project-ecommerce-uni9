package com.uni9.projectecommerceuni9.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoRecordDTO(
    Long id,
    @NotNull Long clienteId,
    @NotNull @Valid List<CarrinhoRecordDTO> itensCarrinho,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm") @NotNull
    LocalDateTime dataPedido,
    @NotNull Double valorTotal) {}
