package com.uni9.projectecommerceuni9.service;

import com.uni9.projectecommerceuni9.model.EnderecoModel;
import com.uni9.projectecommerceuni9.model.dto.EnderecoRecordDTO;
import com.uni9.projectecommerceuni9.repository.EnderecoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

  @Autowired EnderecoRepository enderecoRepository;

  @Transactional
  public EnderecoModel save(EnderecoModel enderecoModel) {
    return enderecoRepository.save(enderecoModel);
  }

  @Transactional
  public List<EnderecoModel> saveAllEnderecos(List<EnderecoModel> enderecoModelList) {
    List<EnderecoModel> enderecoList = new ArrayList<>(enderecoModelList.size());
    for (EnderecoModel endereco : enderecoModelList) {
      EnderecoModel enderecoModel = this.save(endereco);
      enderecoList.add(enderecoModel);
    }
    return enderecoModelList;
  }

  @Transactional
  public List<EnderecoModel> validateAndTransformEndereco(List<EnderecoRecordDTO> enderecoRecordDTOS) {
    List<EnderecoModel> enderecoModelList = new ArrayList<>();
    for (EnderecoRecordDTO enderecoRecordDTO : enderecoRecordDTOS) {
      EnderecoModel endereco = new EnderecoModel();
      BeanUtils.copyProperties(enderecoRecordDTO, endereco);
      enderecoModelList.add(endereco);
    }
    return enderecoModelList;
  }

  @Transactional
  public List<EnderecoModel> getAll() {
    return enderecoRepository.findAll();
  }

  @Transactional
  public Optional<EnderecoModel> getById(Long id) {
    return enderecoRepository.findById(id);
  }
}