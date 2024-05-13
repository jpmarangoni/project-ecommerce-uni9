package com.uni9.projectecommerceuni9.model.dto;

import jakarta.validation.constraints.NotBlank;

public record TelefoneRecordDTO(Long id, @NotBlank String telefone) {}
