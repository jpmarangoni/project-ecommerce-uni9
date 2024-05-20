package com.uni9.projectecommerceuni9.service;

import com.uni9.projectecommerceuni9.enums.StatusPedido;
import com.uni9.projectecommerceuni9.mapper.PedidoMapper;
import com.uni9.projectecommerceuni9.mapper.response.PedidoResponseMapper;
import com.uni9.projectecommerceuni9.model.CarrinhoModel;
import com.uni9.projectecommerceuni9.model.PedidoModel;
import com.uni9.projectecommerceuni9.model.dto.PedidoRecordDTO;
import com.uni9.projectecommerceuni9.model.dto.response.PedidoRecordResponseDTO;
import com.uni9.projectecommerceuni9.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    @Autowired
    PedidoMapper pedidoMapper;

    @Autowired
    PedidoResponseMapper pedidoResponseMapper;

    @Autowired
    PedidoRepository pedidoRepository;
    
    @Autowired
    CarrinhoService carrinhoService;

    @Autowired
    LivroService livroService;

    @Transactional
    public PedidoRecordResponseDTO save(PedidoRecordDTO pedidoDTO){
//        criaPedido(pedidoModel);
        List<CarrinhoModel> carrinhoDTO = carrinhoService.saveItem(pedidoDTO.itensCarrinho(), pedidoDTO);
        PedidoModel pedidoModel = pedidoMapper.dtoToModel(pedidoDTO);
        pedidoModel.setItensCarrinho(carrinhoDTO);
        if(pedidoModel.getStatusPedido() == null){
            pedidoModel.setStatusPedido(StatusPedido.EM_ABERTO.getStatusPedido());
        }
        pedidoRepository.save(pedidoModel);
        return pedidoResponseMapper.requestToResponse(pedidoMapper.modelToDto(pedidoModel));
    }
        //todo criar classe de item do pedido e chamar a lista de livros por lá
}
