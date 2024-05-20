package com.uni9.projectecommerceuni9.service;

import com.uni9.projectecommerceuni9.model.LivroModel;
import com.uni9.projectecommerceuni9.repository.LivroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LivroService {

  @Autowired LivroRepository livroRepository;

  @Transactional
  public LivroModel save(LivroModel livroModel) {
    return livroRepository.save(livroModel);
  }

  @Transactional
  public List<LivroModel> getAll() {
    return livroRepository.findAll();
  }

  @Transactional
  public LivroModel getById(Long id) {
    return livroRepository.buscaLivroPorId(id);
  }
}
