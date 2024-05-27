package com.uni9.projectecommerceuni9.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uni9.projectecommerceuni9.model.dto.ClienteRecordDTO;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record PedidoRecordResponseDTO(
    Long id,
    ClienteRecordDTO clienteId,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    @NotBlank LocalDateTime dataPedido,
    CarrinhoResponseDTO carrinhoId,
    @NotBlank String statusPedido,
    @NotBlank Double valorTotal) {}
