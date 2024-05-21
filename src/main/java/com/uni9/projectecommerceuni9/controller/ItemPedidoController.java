package com.uni9.projectecommerceuni9.controller;

import com.uni9.projectecommerceuni9.model.dto.CarrinhoRecordDTO;
import com.uni9.projectecommerceuni9.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemPedidoController {

    @Autowired
    CarrinhoService carrinhoService;

    @PostMapping("/itens")
    public ResponseEntity<Object> saveItens(@RequestBody CarrinhoRecordDTO carrinhoRecordDTO){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
