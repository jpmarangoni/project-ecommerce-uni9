package com.uni9.projectecommerceuni9.service;

import com.uni9.projectecommerceuni9.enums.StatusPedido;
import com.uni9.projectecommerceuni9.mapper.PedidoMapper;
import com.uni9.projectecommerceuni9.mapper.response.PedidoResponseMapper;
import com.uni9.projectecommerceuni9.model.CarrinhoModel;
import com.uni9.projectecommerceuni9.model.ClienteModel;
import com.uni9.projectecommerceuni9.model.PedidoModel;
import com.uni9.projectecommerceuni9.model.dto.PedidoRecordDTO;
import com.uni9.projectecommerceuni9.model.dto.response.PedidoRecordResponseDTO;
import com.uni9.projectecommerceuni9.repository.ClienteRepository;
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
    ClienteRepository clienteRepository;

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
        ClienteModel cliente = clienteRepository.getById(pedidoModel.getClienteId());
        pedidoModel.setItensCarrinho(carrinhoDTO);
        pedidoModel.setCliente(cliente);
        if(pedidoModel.getStatusPedido() == null){
            pedidoModel.setStatusPedido(StatusPedido.EM_ABERTO.getStatusPedido());
        }

        PedidoModel pedidoSalvo = pedidoRepository.save(pedidoModel);
        PedidoRecordResponseDTO pedidoTransformado = pedidoResponseMapper.modelToResponseDto(pedidoSalvo);
        return pedidoTransformado;
    }
        //todo criar classe de item do pedido e chamar a lista de livros por lá
}
