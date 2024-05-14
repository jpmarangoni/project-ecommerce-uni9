package com.uni9.projectecommerceuni9.service;

import com.uni9.projectecommerceuni9.enums.TipoCliente;
import com.uni9.projectecommerceuni9.mapper.ClienteMapper;
import com.uni9.projectecommerceuni9.model.ClienteModel;
import com.uni9.projectecommerceuni9.model.EnderecoModel;
import com.uni9.projectecommerceuni9.model.TelefoneModel;
import com.uni9.projectecommerceuni9.model.dto.ClienteRecordDTO;
import com.uni9.projectecommerceuni9.model.dto.EnderecoRecordDTO;
import com.uni9.projectecommerceuni9.model.dto.TelefoneRecordDTO;
import com.uni9.projectecommerceuni9.repository.ClienteRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClienteService {

  @Autowired ClienteRepository clienteRepository;

  @Autowired EnderecoService enderecoService;

  @Autowired TelefoneService telefoneService;

  @Autowired ClienteMapper clienteMapper;

  @Transactional
  public ClienteRecordDTO save(ClienteRecordDTO clienteDTO) {
    ClienteModel cliente = clienteMapper.dtoToModel(clienteDTO);

    verificaTipoCliente(cliente);
    criarTelefone(clienteDTO.telefones(), cliente);
    criarEndereco(clienteDTO.enderecos(), cliente);
    ClienteModel clienteSalvo = clienteRepository.save(cliente);
    return clienteMapper.modelToDto(clienteSalvo);
  }

  @Transactional
  public List<ClienteRecordDTO> getAll() {
    return clienteMapper.modelListToDtoList(clienteRepository.findAll());
  }

  @Transactional
  public ClienteRecordDTO getById(Long id) {
    ClienteModel cliente = clienteRepository.getById(id);
    return clienteMapper.modelToDto(cliente);
  }

  private void verificaTipoCliente(ClienteModel cliente){
    if(cliente.getCnpj() != null){
      cliente.setTipoCliente(TipoCliente.CLIENTE_PJ.getTipoCliente());
    } else {
      cliente.setTipoCliente(TipoCliente.CLIENTE_PF.getTipoCliente());
    }
  }

  private void criarTelefone(List<TelefoneRecordDTO> telefones, ClienteModel cliente) {
    List<TelefoneModel> telefoneList = new ArrayList<>(telefones.size());
    telefones.forEach(
        salvaTelefone -> {
          TelefoneModel novoTelefone = criarEntidadeTelefone(cliente, salvaTelefone);
          telefoneList.add(novoTelefone);
        });
    cliente.setTelefones(telefoneList);
  }

  private void criarEndereco(List<EnderecoRecordDTO> enderecos, ClienteModel cliente) {
    List<EnderecoModel> enderecoList = new ArrayList<>(enderecos.size());
    enderecos.forEach(
        salvaEndereco -> {
          EnderecoModel novoEndereco = criarEntidadeEndereco(cliente, salvaEndereco);
          enderecoList.add(novoEndereco);
        });
    cliente.setEnderecos(enderecoList);
  }

  private EnderecoModel criarEntidadeEndereco(
      ClienteModel clienteModel, EnderecoRecordDTO enderecoDTO) {
    EnderecoModel endereco = new EnderecoModel();
    endereco.setCliente(clienteModel);
    endereco.setLogradouro(enderecoDTO.logradouro());
    endereco.setNumero(enderecoDTO.numero());
    endereco.setComplemento(enderecoDTO.complemento());
    endereco.setBairro(enderecoDTO.bairro());
    endereco.setCidade(enderecoDTO.cidade());
    endereco.setUf(enderecoDTO.uf());
    endereco.setCep(enderecoDTO.cep());

    return endereco;
  }

  private TelefoneModel criarEntidadeTelefone(
      ClienteModel clienteModel, TelefoneRecordDTO telefoneDTO) {
    return TelefoneModel.builder().telefone(telefoneDTO.telefone()).cliente(clienteModel).build();
  }
}
