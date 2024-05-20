package com.uni9.projectecommerceuni9.mapper;

import com.uni9.projectecommerceuni9.model.LivroModel;
import com.uni9.projectecommerceuni9.model.dto.LivroRecordDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LivroMapper {
  LivroModel dtoToModel(LivroRecordDto livroRecordDto);

  LivroRecordDto modelToDto(LivroModel livroModel);

  List<LivroModel> dtoToModelList(List<LivroRecordDto> livroRecordDto);

  List<LivroRecordDto> modelToDtoList(List<LivroModel> livroModel);
}