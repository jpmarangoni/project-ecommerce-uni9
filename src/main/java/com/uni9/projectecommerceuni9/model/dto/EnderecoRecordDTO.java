package com.uni9.projectecommerceuni9.model.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoRecordDTO(
    @NotBlank String logradouro,
    @NotBlank String numero,
    @NotBlank String complemento,
    @NotBlank String cidade,
    @NotBlank String cep,
    @NotBlank String bairro,
    @NotBlank String uf) {}
