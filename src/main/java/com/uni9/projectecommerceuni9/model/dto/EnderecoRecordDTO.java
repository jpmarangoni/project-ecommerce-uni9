package com.uni9.projectecommerceuni9.model.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoRecordDTO(
    Long id,
    @NotBlank String logradouro,
    @NotBlank String numero,
    String complemento,
    @NotBlank String cidade,
    @NotBlank String cep,
    String bairro,
    @NotBlank String uf) {}
