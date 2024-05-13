package com.uni9.projectecommerceuni9.mapper;

import com.uni9.projectecommerceuni9.model.ClienteModel;
import com.uni9.projectecommerceuni9.model.dto.ClienteRecordDTO;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClienteMapper {
  ClienteModel dtoToModel(ClienteRecordDTO clienteDTO);

  ClienteRecordDTO modelToDto(ClienteModel clienteModel);

  //  List<ClienteModel> dtoListToModelList(List<ClienteRecordDTO> clienteDTO);

  List<ClienteRecordDTO> modelListToDtoList(List<ClienteModel> clienteModel);
}
