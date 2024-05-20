package com.uni9.projectecommerceuni9.mapper;

import com.uni9.projectecommerceuni9.model.CarrinhoModel;
import com.uni9.projectecommerceuni9.model.dto.CarrinhoRecordDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CarrinhoMapper {
  CarrinhoModel dtoToModel(CarrinhoRecordDTO carrinhoRecordDTO);

  CarrinhoRecordDTO modelToDto(CarrinhoModel carrinhoModel);

  List<CarrinhoModel> dtoToModelList(List<CarrinhoRecordDTO> carrinhoRecordDTOList);

  List<CarrinhoRecordDTO> modelToDtoList(List<CarrinhoModel> carrinhoModelList);
}
