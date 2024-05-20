package com.uni9.projectecommerceuni9.mapper;

import com.uni9.projectecommerceuni9.model.PedidoModel;
import com.uni9.projectecommerceuni9.model.dto.PedidoRecordDTO;
import com.uni9.projectecommerceuni9.model.dto.response.PedidoRecordResponseDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PedidoMapper {

    PedidoModel dtoToModel(PedidoRecordDTO pedidoRecordDTO);

    PedidoRecordDTO modelToDto(PedidoModel pedidoModel);

    PedidoRecordResponseDTO modelToDtoResponse(PedidoModel pedidoModel);

}
