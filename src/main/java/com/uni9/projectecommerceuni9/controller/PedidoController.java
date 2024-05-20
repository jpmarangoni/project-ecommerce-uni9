package com.uni9.projectecommerceuni9.controller;

import com.uni9.projectecommerceuni9.model.dto.PedidoRecordDTO;
import com.uni9.projectecommerceuni9.model.dto.response.PedidoRecordResponseDTO;
import com.uni9.projectecommerceuni9.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {
    
    @Autowired
    PedidoService pedidoService;

    @PostMapping("/pedido")
    public ResponseEntity<PedidoRecordResponseDTO> savePedido(@RequestBody @Valid PedidoRecordDTO pedidoRecordDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedidoRecordDTO));
    }
}
