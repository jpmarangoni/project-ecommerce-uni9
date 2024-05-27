package com.uni9.projectecommerceuni9.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uni9.projectecommerceuni9.model.CarrinhoModel;
import com.uni9.projectecommerceuni9.model.ClienteModel;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record PedidoRecordDTO(
    Long id,
    ClienteModel clienteId, //Vai vir da hora de finalizar o carrinho
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    @NotNull LocalDateTime dataPedido,
    CarrinhoModel carrinhoId,
    String statusPedido,
    Double valorTotal) {}
