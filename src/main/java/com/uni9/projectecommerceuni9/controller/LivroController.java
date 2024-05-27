package com.uni9.projectecommerceuni9.controller;

import com.uni9.projectecommerceuni9.model.LivroModel;
import com.uni9.projectecommerceuni9.model.dto.LivroRecordDto;
import com.uni9.projectecommerceuni9.service.LivroService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class LivroController {

  @Autowired LivroService livroService;

  @PostMapping("/livro")
  public ResponseEntity<LivroModel> saveLivro(@RequestBody @Valid LivroRecordDto livroRecordDto) {
    LivroModel livroModel = new LivroModel();
    BeanUtils.copyProperties(livroRecordDto, livroModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livroModel));
  }

  @GetMapping("/livros")
  public ResponseEntity<List<LivroModel>> getAll() {
    return ResponseEntity.status(HttpStatus.OK).body(livroService.getAll());
  }

  @GetMapping("/livro/{id}")
  public ResponseEntity<LivroModel> getById(@PathVariable("id") Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(livroService.getById(id));
  }
}
