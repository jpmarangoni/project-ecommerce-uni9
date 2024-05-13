package com.uni9.projectecommerceuni9.service;

import com.uni9.projectecommerceuni9.model.TelefoneModel;
import com.uni9.projectecommerceuni9.model.dto.TelefoneRecordDTO;
import com.uni9.projectecommerceuni9.repository.TelefoneRepository;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TelefoneService {

  @Autowired TelefoneRepository telefoneRepository;

  @Transactional
  public TelefoneModel save(TelefoneModel telefoneModel) {
    return telefoneRepository.save(telefoneModel);
  }

  @Transactional
  public void saveAllTelefones(List<TelefoneModel> telefoneModelList) {
    for (TelefoneModel telefone : telefoneModelList) {
      this.save(telefone);
    }
  }

  @Transactional
  public List<TelefoneModel> validateAndTransformTelefone(List<TelefoneRecordDTO> telefoneRecordDTOS) {
    List<TelefoneModel> telefoneModelList = new ArrayList<>();
    for (TelefoneRecordDTO telefoneRecordDTO : telefoneRecordDTOS) {
      TelefoneModel telefone = new TelefoneModel();
      BeanUtils.copyProperties(telefoneRecordDTO, telefone);
      telefoneModelList.add(telefone);
    }
    return telefoneModelList;
  }

  @Transactional
  public List<TelefoneModel> getAll() {
    return telefoneRepository.findAll();
  }

  @Transactional
  public Optional<TelefoneModel> getById(Long id) {
    return telefoneRepository.findById(id);
  }
}
