package com.uni9.projectecommerceuni9.controller;

import com.uni9.projectecommerceuni9.model.dto.ClienteRecordDTO;
import com.uni9.projectecommerceuni9.service.ClienteService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class ClienteController {

  @Autowired ClienteService clienteService;

  @PostMapping("/cliente")
  public ResponseEntity<ClienteRecordDTO> saveCliente(
      @RequestBody @Valid ClienteRecordDTO clienteRecordDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteRecordDTO));
  }

  @GetMapping("/clientes")
  public ResponseEntity<List<ClienteRecordDTO>> getAll() {
    return ResponseEntity.status(HttpStatus.OK).body(clienteService.getAll());
  }

  @GetMapping("/cliente/{id}")
  public ResponseEntity<ClienteRecordDTO> getById(@PathVariable("id") Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(clienteService.getById(id));
  }
}
