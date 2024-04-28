package com.uni9.projectecommerceuni9.model.dto;

import com.uni9.projectecommerceuni9.model.EnderecoModel;
import com.uni9.projectecommerceuni9.model.TelefoneModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record ClienteRecordDTO(
        @NotBlank String nome,
        @NotBlank EnderecoModel endereco,
        @NotBlank List<TelefoneModel> telefones,
        @NotBlank @Email String email,
        @CPF String cpf,
        @CNPJ String cnpj
        ) {}
