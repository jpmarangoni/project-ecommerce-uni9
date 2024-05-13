package com.uni9.projectecommerceuni9.controller;

import com.uni9.projectecommerceuni9.model.EnderecoModel;
import com.uni9.projectecommerceuni9.model.dto.EnderecoRecordDTO;
import com.uni9.projectecommerceuni9.service.EnderecoService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnderecoController {

  @Autowired EnderecoService enderecoService;

  @PostMapping("/endereco")
  public ResponseEntity<EnderecoModel> saveEndereco(
      @RequestBody @Valid EnderecoRecordDTO enderecoRecordDTO) {
    EnderecoModel enderecoModel = new EnderecoModel();
    BeanUtils.copyProperties(enderecoRecordDTO, enderecoModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(enderecoModel));
  }

  @GetMapping("/enderecos")
  public ResponseEntity<List<EnderecoModel>> getAll() {
    return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getAll());
  }

  @GetMapping("/endereco/{id}")
  public ResponseEntity<Optional<EnderecoModel>> getById(@PathVariable("id") Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getById(id));
  }
}
