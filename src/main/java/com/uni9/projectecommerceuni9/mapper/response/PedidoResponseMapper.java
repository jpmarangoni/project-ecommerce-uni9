package com.uni9.projectecommerceuni9.mapper.response;

import com.uni9.projectecommerceuni9.model.PedidoModel;
import com.uni9.projectecommerceuni9.model.dto.PedidoRecordDTO;
import com.uni9.projectecommerceuni9.model.dto.response.PedidoRecordResponseDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PedidoResponseMapper {

    PedidoRecordResponseDTO requestToResponse(PedidoRecordDTO pedidoRequest);

    PedidoRecordDTO responseToRequest(PedidoRecordResponseDTO pedidoResponse);

}
