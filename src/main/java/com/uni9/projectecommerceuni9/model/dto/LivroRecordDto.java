package com.uni9.projectecommerceuni9.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRecordDto(
    Long id,
    @NotBlank String titulo,
    @NotBlank String linkImagem,
    @NotBlank String numeroPaginas,
    @NotBlank String idioma,
    @NotBlank String editora,
    @NotBlank String autor,
    @NotBlank String descricao,
    @NotBlank String anoEdicao,
    @NotNull Double preco) {}
