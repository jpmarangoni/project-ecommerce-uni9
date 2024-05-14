package com.uni9.projectecommerceuni9.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteRecordDTO(
    Long id,
    @NotBlank String nome,
    @NotNull @Valid List<EnderecoRecordDTO> enderecos,
    @NotNull @Valid List<TelefoneRecordDTO> telefones,
    @NotBlank @Email String email,
    @CPF String cpf,
    @CNPJ String cnpj,
    String tipoCliente) {}
